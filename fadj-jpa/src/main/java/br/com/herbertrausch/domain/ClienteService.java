package br.com.herbertrausch.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import br.com.herbertrausch.persistence.ConnectionJpa;

public class ClienteService {

	private EntityManagerFactory emf;
	private ClienteDAO db; 
	
	public ClienteService(){
		
		try {
		
			this.emf = ConnectionJpa.getInstance().getEntityManagerFactory();
			db = new ClienteDAO();
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	// Lista todos os clinetes do banco de dados
	public List<Cliente> getClientes() {
		try {
			
			List<Cliente> clientes = db.findEntities();
			return clientes;
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Cliente>();

		}
	}

	public Cliente getCliente(Long id) {
		try {
			
			return db.findById(id);
			
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
			
			if(cliente.getId() == null )
				db.create(cliente);
			else
				db.update(cliente);
			
			return true;
		}  catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}



}
