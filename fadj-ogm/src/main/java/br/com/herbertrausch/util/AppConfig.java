package br.com.herbertrausch.util;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@ComponentScan({ "br.com.herbertrausch.util", "br.com.herbertrausch.spring.mongo"})
@EnableMongoRepositories("br.com.herbertrausch.spring.mongo")
@Import({ MongoConfig.class })
public class AppConfig {

}
