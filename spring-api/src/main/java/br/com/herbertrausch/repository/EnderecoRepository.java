package br.com.herbertrausch.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.herbertrausch.model.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long> {
	

}
