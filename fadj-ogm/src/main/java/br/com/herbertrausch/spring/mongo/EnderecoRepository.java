package br.com.herbertrausch.spring.mongo;

import java.util.List;

import org.springframework.data.geo.Box;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository  extends MongoRepository<Endereco, String> {
	
	List<Endereco> findByEstado(String estado);
	
	 @Query("{ 'estado' : ?0 }")
	 List<Endereco> findByEstado2(String texto);
	 
	 
	 List<Endereco> findByRuaLike(String texto);
	 
	 GeoResults<Endereco> findByLocalizacaoNear(Point point, Distance distance);
	 
	 List<Endereco> findByLocalizacaoWithin(Circle c);
	 

}

