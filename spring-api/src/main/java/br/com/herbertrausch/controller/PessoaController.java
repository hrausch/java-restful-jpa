package br.com.herbertrausch.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.herbertrausch.model.Pessoa;
import br.com.herbertrausch.repository.PessoaRepository;

@RestController
public class PessoaController {
	
	@Autowired
	PessoaRepository repo;
	
    @RequestMapping(value = "/pessoa", method = RequestMethod.GET)
    public ArrayList<Pessoa> listPokemons() {
    	
    	return (ArrayList<Pessoa>) repo.findAll();
    }
    
    
    
    @RequestMapping(value = "/pessoa", method = RequestMethod.POST)
    public Pessoa create(@RequestBody Pessoa jogador) {
 
    	repo.save(jogador);
 
        return jogador;
    }

}
