package br.com.herbertrausch.rest;

import java.util.ArrayList;
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
import br.com.herbertrausch.domain.Endereco;
import br.com.herbertrausch.domain.EnderecoService;
import br.com.herbertrausch.domain.Pais;
import br.com.herbertrausch.domain.Response;

@Path("/enderecos")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class EnderecoResource {
	
	private EnderecoService service = new EnderecoService();
	private ClienteService serviceCliente = new ClienteService();

	@GET
	public List<Endereco> get() {
		List<Endereco> lista = service.getEnderecos();
		return lista;
	}

	@GET
	@Path("{id}")
	public Endereco get(@PathParam("id") long id) {
		Endereco e = service.getEndereco(id);
		return e;
	}

	@GET
	@Path("/cliente/{id}")
	public List<Endereco> getByClienteId(@PathParam("id") long id) {
		
		List<Endereco> lista = new ArrayList<Endereco>();
		Cliente	c = serviceCliente.getCliente(id);
		if(c != null)
			lista = service.getEnderecosByCliente(c);
		return lista;
	}
	

	
	@GET
	@Path("/{cid}/{pid}/{uf}")
	public List<Endereco> getByClientePaisUf(@PathParam("cid") long cid, @PathParam("pid") long pid, @PathParam("uf") String uf ) {
		
		List<Endereco> lista = new ArrayList<Endereco>();
		Cliente	c = serviceCliente.getCliente(cid);
		Pais p = new Pais();
		p.setId(pid);
		if(c != null)
			lista = service.getEnderecosByClienteAndPaisAndUf(c, p, uf);
		return lista;
	}
	
	@GET
	@Path("/uf/{uf}")
	public List<Endereco> getByUf(@PathParam("uf") String uf) {
		List<Endereco> lista = service.getEnderecosByUf(uf);
		return lista;
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") long id) {
		service.delete(id);
		return Response.Ok("Endereco deletado com sucesso");
	}

	@POST
	public Response post(Endereco e) {
		service.save(e);
		return Response.Ok("Endereco salvo com sucesso");
	}

	@PUT
	public Response put(Endereco e) {
		service.save(e);
		return Response.Ok("Endereco atualizado com sucesso");
	}


}
