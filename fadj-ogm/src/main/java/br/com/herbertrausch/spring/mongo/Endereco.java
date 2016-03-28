package br.com.herbertrausch.spring.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "endereco")
public class Endereco {

	@Id
	private String id;
	
	@GeoSpatialIndexed
	 private double[] localizacao;
	
	private String rua;
	private String estado;
	private String cidade;
	

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
