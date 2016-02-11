package br.com.herbertrausch.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoService {

	private EnderecoDAO db = new EnderecoDAO();

	public List<Endereco> getEnderecos() {
		try {
			
			List<Endereco> enderecos = db.getEnderecos();
			return enderecos;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Endereco>();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Endereco>();
		}
	}

	public Endereco getEndereco(Long id) {
		try {
			
			return db.getEnderecoById(id);
			
		} catch (SQLException e) {
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Endereco> getEnderecosByCliente(Long id) {
		try {
			
			List<Endereco> enderecos = db.getEnderecoByClienteId(id);
			return enderecos;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Endereco>();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Endereco>();
		}
	}



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

	public boolean save(Endereco endereco) {
		try {
			db.save(endereco);
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
