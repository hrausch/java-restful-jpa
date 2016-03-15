package br.com.herbertrausch.spring.mongo;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Produto {
	
	private String nome;
	private float valor;
	
	List<ProdutoAtributo> atributos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public List<ProdutoAtributo> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<ProdutoAtributo> atributos) {
		this.atributos = atributos;
	}
	
	

}


@Document
class ProdutoAtributo{
	
	private String atributo, valorAtributo;

	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	public String getValorAtributo() {
		return valorAtributo;
	}

	public void setValorAtributo(String valorAtributo) {
		this.valorAtributo = valorAtributo;
	}
	
	
	
}
