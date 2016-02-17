package br.com.herbertrausch.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.herbertrausch.domain.Cliente;
import br.com.herbertrausch.domain.ClienteService;
import br.com.herbertrausch.domain.Response;

@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ClientesResource {
	
	public ClienteService clienteService = new ClienteService();
	

	@GET
	public List<Cliente> get() {
		List<Cliente> clientes = clienteService.getClientes();
		return clientes;
	}

	@GET
	@Path("{id}")
	public Cliente get(@PathParam("id") long id) {
		Cliente c = clienteService.getCliente(id);
		return c;
	}

	@GET
	@Path("/nome/{nome}")
	public List<Cliente> getByNome(@PathParam("nome") String nome) {
		List<Cliente> clientes = clienteService.getByNome(nome);
		return clientes;
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") long id) {
		clienteService.delete(id);
		return Response.Ok("Cliente deletado com sucesso");
	}

	@POST
	public Response post(Cliente c) {
		clienteService.save(c);
		return Response.Ok("Cliente salvo com sucesso");
	}

	@PUT
	public Response put(Cliente c) {
		clienteService.save(c);
		return Response.Ok("Cliente atualizado com sucesso");
	}

}
