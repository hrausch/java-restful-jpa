package br.com.herbertrausch.spring.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository  extends MongoRepository<Produto, String> {
	
	List<Produto> findByAtributosAtributo(String nomeAtributo);
	
	List<Produto> findByValorLessThan(float valor);
	
	List<Produto> findByValorBetween(int from, int to);
	
	void deleteByAtributosAtributo(String nomeAtributo);


}
