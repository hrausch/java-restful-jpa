package br.com.herbertrausch.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.herbertrausch.spring.mongo.Endereco;
import br.com.herbertrausch.spring.mongo.Produto;
import br.com.herbertrausch.spring.mongo.ProdutoService;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ProdutoResource {

	ProdutoService service = new ProdutoService();
	
	@GET
	public List<Produto> get() {
		
		return service.getAll();
		
	}
	
	@GET
	@Path("/atributo/{texto}")
	public List<Produto> getByEstado(@PathParam("texto") String texto) {
		return service.getByAtributo(texto);
	}
	
	@POST
	public void save(Produto e){
		
		service.insert(e);
		
	}

}
