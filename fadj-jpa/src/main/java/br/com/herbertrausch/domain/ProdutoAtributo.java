package br.com.herbertrausch.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: ProdutoAtributo
 *
 */
@Entity
@Table(name="atributos_produtos")
public class ProdutoAtributo implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProdutoAtributo;
	
	@Basic(fetch=FetchType.LAZY)
	@Column(name="nome_atributo")
	private String nomeAtributo;
	
	@Column(name="valor_atributo")
	private String valorAtributo;
	
	@ManyToOne
	private Produto produto;
	
	
	public long getIdProdutoAtributo() {
		return idProdutoAtributo;
	}
	public void setIdProdutoAtributo(long idProdutoAtributo) {
		this.idProdutoAtributo = idProdutoAtributo;
	}
	public String getNomeAtributo() {
		return nomeAtributo;
	}
	public void setNomeAtributo(String nomeAtributo) {
		this.nomeAtributo = nomeAtributo;
	}
	public String getValorAtributo() {
		return valorAtributo;
	}
	public void setValorAtributo(String valorAtributo) {
		this.valorAtributo = valorAtributo;
	}
	
	

   
}
