package br.com.herbertrausch.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ClienteRepository extends CrudRepository<Cliente, Long>, 
											ClienteRepositoryCustom {
	
	List<Cliente> findByNome(String nome);
	
}

