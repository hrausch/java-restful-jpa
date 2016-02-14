package br.com.herbertrausch.domain;

import java.util.ArrayList;
import java.util.List;

public class EnderecoService {

	private EnderecoDAO db = new EnderecoDAO();

	public List<Endereco> getEnderecos() {
		try {
			
			List<Endereco> enderecos = db.findEntities();
			return enderecos;
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Endereco>();

		}
	}

	public Endereco getEndereco(Long id) {
		try {
			
			return db.findById(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	


	public boolean delete(Long id) {
		try {
			db.delete(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean save(Endereco endereco) {
		try {
			db.create(endereco);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
