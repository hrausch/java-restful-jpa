package br.com.herbertrausch.spring.mongo;

import java.util.List;

import org.springframework.context.ApplicationContext;

import br.com.herbertrausch.util.SpringUtil;

public class ProdutoService {

	private ProdutoRepository db;
	
	public ProdutoService(){
	
		ApplicationContext context =SpringUtil.getContext();
		db =  context.getBean(ProdutoRepository.class);
	}
	
	public void insert(Produto e){
		db.save(e);
	}
	
	public List<Produto> getAll(float valor){
		
		return db.findByValorLessThan(valor);
	}
	
	public List<Produto> getAll(int from, int to){
		
		return db.findByValorBetween(from, to);
	}
	
	
	public void deleteByAtributo(String nomeAtributo){
		db.deleteByAtributosAtributo(nomeAtributo);
	}
	
	public List<Produto> getAll(){
		
		return db.findAll();
	}
	
	public List<Produto> getByAtributo(String atributo){
		
		return db.findByAtributosAtributo(atributo);
	}

}

