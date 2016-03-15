package br.com.herbertrausch.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.herbertrausch.util.SpringUtil;

public class ClienteService {

	
	private ClienteRepository db;
	
	public ClienteService(){
		
		ApplicationContext context=SpringUtil.getContext();
		db = context.getBean(ClienteRepository.class);
		
	}

	// Lista todos os clinetes do banco de dados
	public List<Cliente> getClientes() {
		try {
			
			List<Cliente> clientes = (List<Cliente>) db.findAll();
					
			return clientes;
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Cliente>();

		}
	}
	
	public List<Cliente> getByNome(String a){
		return db.findByNome(a);
	}
	
	public Cliente getByNome2(String a){
		return db.findClientePeloNome(a);
	}

	public Cliente getCliente(Long id) {
		try {
			
			
			return db.findOne(id);
			
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	// Deleta o carro pelo id
	public boolean delete(Long id) {
		try {
			db.delete(id);
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// Salva ou atualiza o carro
	public boolean save(Cliente cliente) {
		try {
			
				db.save(cliente);
			
			return true;
		}  catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}



}
