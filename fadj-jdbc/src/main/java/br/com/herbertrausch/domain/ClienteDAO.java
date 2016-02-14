package br.com.herbertrausch.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.herbertrausch.persistence.ConnectionSingleton;


public class ClienteDAO {

	/**
	 * Retorna a lista de todos os clientes armazenados no BD.
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Cliente> getClientes() throws SQLException, ClassNotFoundException {

		List<Cliente> clientes = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			//realiza a conexão com o banco de dados.
			conn =ConnectionSingleton.getInstance().getConnection();

			//query a ser executada.
			stmt = conn.prepareStatement("select * from cliente");

			//Query é executada e o retorno é referenciado pelo ResultSet
			ResultSet rs = stmt.executeQuery();

			//Realiza um loop iterando por cada tupla retornada no BD.
			while (rs.next()) {

				//Atribue-se os valores retornados no BD nos atributos da classe cliente
				Cliente c = createCliente(rs);

				//Adiciona o objeto ao vetor que será retornado.
				clientes.add(c);
			}

			//realiza o fechamento dos recursos
			rs.close();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return clientes;
	}

	/**
	 * Retorna um objeto cliente que representa a tupla que satisfaz a condição na query.
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Cliente getClienteById(Long id) throws SQLException, ClassNotFoundException {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = ConnectionSingleton.getInstance().getConnection();

			stmt = conn.prepareStatement("select * from cliente where id=?");
			
			// substitue o primeiro '?' pelo valor de id.
			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Cliente c = createCliente(rs);
				rs.close();
				return c;
			}
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return null;
	}

	/**
	 * Retorna uma lista de clientes que satisfazem a condição de nome.
	 * @param name
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<Cliente> findByName(String name) throws SQLException, ClassNotFoundException {
		List<Cliente> clientes = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = ConnectionSingleton.getInstance().getConnection();

			stmt = conn.prepareStatement("select * from cliente where lower(nome) like ?");
			
			//substitue o primeiro '?' por '"%" + name.toLowerCase() +"%"'
			stmt.setString(1, "%" + name.toLowerCase() +"%");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente c = createCliente(rs);
				clientes.add(c);
			}

			rs.close();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return clientes;
	}

	/**
	 * Se o objeto recebido como parâmetro não tiver valor no atributo id, realiza a operação de insert;
	 * Se existir valor no atribut id, realiza a operação update.
	 * @param c
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void save(Cliente c) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ConnectionSingleton.getInstance().getConnection();
			if (c.getId() == null) {
				stmt = conn
						.prepareStatement(
								"insert into cliente (nome,sobrenome,email) VALUES(?,?,?)",
								Statement.RETURN_GENERATED_KEYS);
			} else {
				stmt = conn
						.prepareStatement("update cliente set nome=?,sobrenome=?,email=? where id=?");
			}

			stmt.setString(1, c.getNome()); //substitue o primeiro '?' pelo valor de c.getNome
			stmt.setString(2, c.getSobrenome()); //substitue o segundo '?' pelo valor de c.getSobrenome
			stmt.setString(3, c.getEmail()); //substitue o terceiro '?' pelo valor de c.getEmail

			//se for update
			if (c.getId() != null) {
				stmt.setLong(4, c.getId()); //substitue o quarto '?' pelo valor de c.getId
			}

			//executa a consulta e retorna o número de tuplas afetas pela operação no BD.
			int count = stmt.executeUpdate();

			if (count == 0) {
				throw new SQLException("Erro ao inserir o cliente");
			}

			// Se inseriu, ler o id auto incremento
			if (c.getId() == null) {
				Long id = getGeneratedId(stmt);
				c.setId(id);
			}

		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

	/**
	 * retorna o id gerado pelo banco de dados.
	 * @param stmt
	 * @return
	 * @throws SQLException
	 */
	public static Long getGeneratedId(Statement stmt) throws SQLException {

		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			Long id = rs.getLong(1);
			return id;
		}

		return 0L;
	}

	/**
	 * Remove a tupla do banco de dados.
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean delete(Long id) throws SQLException, ClassNotFoundException {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = ConnectionSingleton.getInstance().getConnection();

			stmt = conn.prepareStatement("delete from carro where id=?");
			stmt.setLong(1, id);

			int count = stmt.executeUpdate();

			boolean ok = count > 0;

			return ok;

		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}



	/**
	 * Neste método, recebe uma tupla, rs, e para cada 'coluna' da tupla atribue-se a variável da classe que a representa.
	 * @param rs
	 * @return c 
	 * @throws SQLException
	 */
	public Cliente createCliente(ResultSet rs) throws SQLException {

		Cliente c = new Cliente();

		c.setId(rs.getLong("id"));
		c.setNome(rs.getString("nome"));
		c.setSobrenome(rs.getString("sobrenome"));
		c.setEmail(rs.getString("email"));

		return c;
	}
}
