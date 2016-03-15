package br.com.herbertrausch.spring.mongo;

import java.util.List;

import org.springframework.context.ApplicationContext;

import br.com.herbertrausch.util.SpringUtil;

public class ClienteService {

	private ClienteRepository db;
	private EnderecoRepository dbe;
	
	public ClienteService(){
	
		ApplicationContext context =SpringUtil.getContext();
		db =  context.getBean(ClienteRepository.class);
		dbe =  context.getBean(EnderecoRepository.class);
		
	}
	
	public void insert(Cliente c){
		Endereco e = c.getEnderecos().get(0);
		dbe.save(e);
		db.save(c);
	}
	
	public List<Cliente> getAll(){
		
		return db.findAll();
	}
	
	public List<Cliente> getByEnderecoId(String id){
		
		return db.findByEndereco(id);
	}

}

