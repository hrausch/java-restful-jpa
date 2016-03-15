package br.com.herbertrausch.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.herbertrausch.domain.Produto;
import br.com.herbertrausch.domain.ProdutoService;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ProdutoResource {
	
	private ProdutoService service = new ProdutoService();

	@GET
	public List<Produto> get() {
		List<Produto> lista = service.getProdutos();
		return lista;
	}

	


}
