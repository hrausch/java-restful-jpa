package br.com.herbertrausch.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.herbertrausch.util.SpringUtil;

public class EnderecoService {

	private EnderecoRepository db;
	
	public EnderecoService(){
		
		ApplicationContext context=SpringUtil.getContext();
		db = context.getBean(EnderecoRepository.class);
		
	}

	public List<Endereco> getEnderecosByCliente(Cliente c) {
		try {
			
			List<Endereco> enderecos = db.findEnderecosByCliente(c);
			return enderecos;
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Endereco>();

		}
	}
	
		
	public List<Endereco> getEnderecosByUf(String uf) {
		try {
			
			List<Endereco> enderecos = db.findEnderecosByUf(uf);
			return enderecos;
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Endereco>();

		}
	}
	

	
	public List<Endereco> getEnderecos() {
		try {
			
			List<Endereco> enderecos = (List<Endereco>) db.findAll();
			return enderecos;
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Endereco>();

		}
	}

	public List<Endereco> getEnderecosByClienteAndPaisAndUf(Cliente c, Pais p , String uf) {
		try {
			
			List<Endereco> enderecos = db.findEnderecosByClienteAndPaisAndUf(c, p, uf);
			return enderecos;
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Endereco>();

		}
	}
	
	public Endereco getEndereco(Long id) {
		try {
			
			return db.findOne(id);
			
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
			db.save(endereco);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
