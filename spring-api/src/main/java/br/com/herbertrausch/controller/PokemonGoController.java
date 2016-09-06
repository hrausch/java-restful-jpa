package br.com.herbertrausch.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.herbertrausch.model.Pokemon;
import br.com.herbertrausch.repository.PokemonRepository;

@RestController
public class PokemonGoController {
	
	@Autowired
	PokemonRepository pokeRepo;
	
    @RequestMapping("/pokemongo")
    public ArrayList<Pokemon> listPokemons() {
    	
    	return (ArrayList<Pokemon>) pokeRepo.findAll();
    }

}
