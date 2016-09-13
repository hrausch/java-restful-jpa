package br.com.herbertrausch.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by hrausch on 30/11/14.
 */
@Entity
public class Pessoa {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
    private String nome;
    private String telefone;
    private int idade;


    public Pessoa(){

    }
    public Pessoa(String nome, String telefone, int idade){
        this.nome = nome;
        this.telefone = telefone;
        this.idade = idade;
    }

    
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


}
