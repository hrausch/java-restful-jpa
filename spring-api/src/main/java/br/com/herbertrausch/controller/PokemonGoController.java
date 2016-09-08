package br.com.herbertrausch.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.herbertrausch.model.Pokemon;
import br.com.herbertrausch.repository.PokemonRepository;

@RestController
public class PokemonGoController {
	
	@Autowired
	PokemonRepository pokeRepo;
	
    @RequestMapping(value = "/pokemongo", method = RequestMethod.GET)
    public ArrayList<Pokemon> listPokemons() {
    	
    	return (ArrayList<Pokemon>) pokeRepo.findAll();
    }
    
    
    
    @RequestMapping(value = "/pokemongo", method = RequestMethod.POST)
    public Pokemon create(@RequestBody Pokemon poke) {
 
        pokeRepo.save(poke);
 
        return poke;
    }

}
