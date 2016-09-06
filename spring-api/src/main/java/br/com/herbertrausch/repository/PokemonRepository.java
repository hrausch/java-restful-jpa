package br.com.herbertrausch.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.herbertrausch.model.Pokemon;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
	

}
