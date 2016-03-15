package br.com.herbertrausch.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import br.com.herbertrausch.persistence.ConnectionJpa;

public class ProdutoService {

	private EntityManagerFactory emf;
	private ProdutoDAO db; 
	
	public ProdutoService(){
		
		try {
		
			this.emf = ConnectionJpa.getInstance().getEntityManagerFactory();
			db = new ProdutoDAO();
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	public List<Produto> getProdutos() {
		try {
			
			List<Produto> produtos = db.findEntities();
			return produtos;
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Produto>();

		}
	}
	
	public  List<Object []> getNumeroAtributos(){
		return db.getNumeroAtributos();
	}

	public  List<Object []> getSomaMediaValor(){
		return db.getSomaMediaValor();
	}
	


}
