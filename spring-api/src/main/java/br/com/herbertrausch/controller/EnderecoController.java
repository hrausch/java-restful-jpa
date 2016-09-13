package br.com.herbertrausch.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.herbertrausch.model.Endereco;
import br.com.herbertrausch.model.Pessoa;
import br.com.herbertrausch.repository.EnderecoRepository;

@RestController
public class EnderecoController {
	
	@Autowired
	EnderecoRepository repo;
	
    @RequestMapping(value = "/endereco", method = RequestMethod.GET)
    public ArrayList<Endereco> listPokemons() {
    	
    	return (ArrayList<Endereco>) repo.findAll();
    }
    
    
    
    @RequestMapping(value = "/endereco", method = RequestMethod.POST)
    public Endereco create(@RequestBody Endereco jogador) {
 
    	repo.save(jogador);
 
        return jogador;
    }

}
