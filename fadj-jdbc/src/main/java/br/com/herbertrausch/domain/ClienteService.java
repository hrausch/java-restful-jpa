package br.com.herbertrausch.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteService {

	private ClienteDAO db = new ClienteDAO();

	// Lista todos os clinetes do banco de dados
	public List<Cliente> getClientes() {
		try {
			
			List<Cliente> clientes = db.getClientes();
			return clientes;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Cliente>();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Cliente>();
		}
	}

	public Cliente getCliente(Long id) {
		try {
			
			return db.getClienteById(id);
			
		} catch (SQLException e) {
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<Cliente> findByName(String name) {
		try {
			return db.findByName(name);
		} catch (SQLException e) {
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// Deleta o carro pelo id
	public boolean delete(Long id) {
		try {
			return db.delete(id);
		} catch (SQLException e) {
			return false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	// Salva ou atualiza o carro
	public boolean save(Cliente cliente) {
		try {
			db.save(cliente);
			return true;
		} catch (SQLException e) {
			return false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}



}
