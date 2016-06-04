package br.com.herbertrausch.domain;

import java.io.Serializable;

public class Endereco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	 private double[] localizacao;
	
	private String rua;
	private String estado;
	private String cidade;
	


	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public double[] getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(double[] localizacao) {
		this.localizacao = localizacao;
	}

	
	

}
