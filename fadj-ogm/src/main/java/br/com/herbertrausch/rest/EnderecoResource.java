package br.com.herbertrausch.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.geo.GeoResults;

import br.com.herbertrausch.spring.mongo.Endereco;
import br.com.herbertrausch.spring.mongo.EnderecoService;

@Path("/enderecos")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class EnderecoResource {

	EnderecoService es = new EnderecoService();
	
	@GET
	public List<Endereco> get() {
		
		return es.getAll();
		
	}
	
	@GET
	@Path("/geowithin")
	public List<Endereco> getByLocal2() {
		return es.getByLocationWithin();
	}
	
	@GET
	@Path("/geo/{latitude}/{longitude}/{distancia}")
	public GeoResults<Endereco> getByLocal(@PathParam("latitude") double latitude, @PathParam("longitude") double longitude, @PathParam("distancia") double distancia ) {
		return es.getByLocation(latitude, longitude,  distancia);
	}
	
	@GET
	@Path("/estado/{texto}")
	public List<Endereco> getByEstado(@PathParam("texto") String texto) {
		return es.getByEstado(texto);
	}
	
	@GET
	@Path("/rua/{texto}")
	public List<Endereco> getByRua(@PathParam("texto") String texto) {
		return es.getByRua(texto);
	}

	@PUT
	@Path("/estado/{uf}/{valor}")
	public void update( @PathParam("uf") String busca, @PathParam("valor") String valor){
		
		es.updateByQuery("estado", busca, valor);
		
	}
	
	@POST
	public void save(Endereco e){
		
		es.insert(e);
		
	}


}
