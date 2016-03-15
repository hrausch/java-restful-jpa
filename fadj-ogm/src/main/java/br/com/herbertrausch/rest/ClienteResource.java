package br.com.herbertrausch.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.herbertrausch.spring.mongo.Cliente;
import br.com.herbertrausch.spring.mongo.ClienteService;
import br.com.herbertrausch.spring.mongo.Endereco;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ClienteResource {

	ClienteService service = new ClienteService();
	
	@GET
	public List<Cliente> get() {
		
		return service.getAll();
		
	}
	
	@GET
	@Path("/endereco/{id}")
	public List<Cliente> getByEstado(@PathParam("id") String id) {
		return service.getByEnderecoId(id);
	}
	
	@POST
	public void save(Cliente e){
		
		service.insert(e);
		
	}

}
