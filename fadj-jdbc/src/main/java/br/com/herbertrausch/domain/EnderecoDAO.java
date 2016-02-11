package br.com.herbertrausch.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.herbertrausch.persistence.ConnectionSingleton;


public class EnderecoDAO {


	public List<Endereco> getEnderecos() throws SQLException, ClassNotFoundException {

		List<Endereco> clientes = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn =ConnectionSingleton.getInstance().getConnection();
			stmt = conn.prepareStatement("select * from endereco");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				Endereco c = createEndereco(rs);
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

	public Endereco getEnderecoById(Long id) throws SQLException, ClassNotFoundException {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = ConnectionSingleton.getInstance().getConnection();
			stmt = conn.prepareStatement("select * from endereco where id=?");
			
			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Endereco e = createEndereco(rs);
				rs.close();
				return e;
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


	public List<Endereco> getEnderecoByClienteId(Long id) throws SQLException, ClassNotFoundException {

		List<Endereco> clientes = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn =ConnectionSingleton.getInstance().getConnection();
			stmt = conn.prepareStatement("select * from endereco where cliente_id=?");
			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				Endereco c = createEndereco(rs);
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

	public void save(Endereco e) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {

			conn = ConnectionSingleton.getInstance().getConnection();


			if (e.getId() == null) {
				stmt = conn
						.prepareStatement(
								"insert into endereco (pais,uf,cidade, endereco, cliente_id) VALUES(?,?,?,?,?)",
								Statement.RETURN_GENERATED_KEYS);
			} else {
				stmt = conn
						.prepareStatement("update endereco set pais=?,uf=?,cidade=?, endereco=?, cliente_id=? where id=?");
			}

			
			stmt.setString(1, e.getPais());
			stmt.setString(2, e.getUf()); 
			stmt.setString(3, e.getCidade()); 
			stmt.setString(4, e.getEndereco());
			stmt.setLong(5, e.getClienteId());

			if (e.getId() != null) {
				stmt.setLong(6, e.getId()); 
			}

			int count = stmt.executeUpdate();

			if (count == 0) {
				throw new SQLException("Erro ao inserir o endereco");
			}

			if (e.getId() == null) {
				Long id = getGeneratedId(stmt);
				e.setId(id);
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


	public static Long getGeneratedId(Statement stmt) throws SQLException {

		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			Long id = rs.getLong(1);
			return id;
		}

		return 0L;
	}

	
	public boolean delete(Long id) throws SQLException, ClassNotFoundException {

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = ConnectionSingleton.getInstance().getConnection();

			stmt = conn.prepareStatement("delete from endereco where id=?");
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


	
	public Endereco createEndereco(ResultSet rs) throws SQLException {

		Endereco e = new Endereco();

		e.setId(rs.getLong("id"));
		e.setPais(rs.getString("pais"));
		e.setUf(rs.getString("uf"));
		e.setEndereco(rs.getString("endereco"));
		e.setClienteId(rs.getLong("cliente_id"));

		return e;
	}
}
