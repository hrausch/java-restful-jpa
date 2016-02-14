package br.com.herbertrausch.persistence;

import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionJpa {
	
	private static final String PERSISTENCEUNIT = "fadjjdbc";
	
	private static ConnectionJpa instance;
	private EntityManagerFactory emf;
	
	private ConnectionJpa() {

	}
	
	public static synchronized ConnectionJpa getInstance()
			throws ClassNotFoundException, SQLException {

		if (instance == null)
			instance = new ConnectionJpa();

		return instance;
	}
	
	 public EntityManagerFactory getEntityManagerFactory() {
	        if(emf == null) {
	        	
	        	emf = Persistence.createEntityManagerFactory(PERSISTENCEUNIT);
	        }
	       
	        return emf;
	    }
	 

	
}
