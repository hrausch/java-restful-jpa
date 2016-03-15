package br.com.herbertrausch.spring.mongo;

import org.springframework.data.mongodb.core.query.Criteria;


public interface EnderecoRepositoryCustom {
	
	void findAndUpdate(Criteria cb,String campo, String valor);

}
