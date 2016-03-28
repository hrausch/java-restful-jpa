package br.com.herbertrausch.spring.mongo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.data.geo.Box;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.query.Criteria;

import br.com.herbertrausch.util.SpringUtil;

public class EnderecoService {


	private EnderecoRepository edao;
	private EnderecoRepositoryCustomImpl edaoC;
	
	public EnderecoService(){
	
		ApplicationContext context =SpringUtil.getContext();
		edao =  context.getBean(EnderecoRepository.class);
		edaoC = new EnderecoRepositoryCustomImpl();
	}
	
	
	public GeoResults<Endereco> getByLocation(double latitude, double longitude, double distancia){
		
		Point referenceLocation = new Point(latitude, longitude);
		Distance oneKilometer = new Distance(distancia, Metrics.KILOMETERS);

		GeoResults<Endereco> result = edao.findByLocalizacaoNear(referenceLocation, oneKilometer);
		
		return result;
		
	}
	
	public List<Endereco> getByLocationWithin(){
		
		Circle c = new Circle( -19.98, -43.946, 0.1);

		List<Endereco> result = edao.findByLocalizacaoWithin(c);
		
		return result;
		
	}
	
	public void insert(Endereco e){
		edao.save(e);
	}
	
	public List<Endereco> getAll(){
		
		return edao.findAll();
	}
	
	public List<Endereco> getByEstado(String estado){
		
		return edao.findByEstado2(estado);
	}
	
	public List<Endereco> getByRua(String texto){
		
		return edao.findByRuaLike(texto);
	}
	
	public void updateByQuery(String campo, String busca, String valor){
		edaoC.findAndUpdate(Criteria.where(campo).is(busca), campo, valor);
	}
	

}

