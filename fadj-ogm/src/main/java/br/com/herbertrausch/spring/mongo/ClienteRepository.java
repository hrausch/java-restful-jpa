package br.com.herbertrausch.spring.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository  extends MongoRepository<Cliente, String> {

	@Query("{'enderecos' :{'$ref' : 'endereco' , '$id' : ?0}}")
	List<Cliente> findByEndereco(String enderecoId);
}
