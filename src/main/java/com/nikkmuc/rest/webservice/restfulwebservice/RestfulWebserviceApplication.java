package com.nikkmuc.rest.webservice.restfulwebservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class RestfulWebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebserviceApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenApi(@Value("${app.version}") String appVersion, @Value("${app.name}") String appName){
		return new OpenAPI()
				.info(new Info()
				.title(appName)
				.description("This is a simple Restful Webservice for demo purpose.")
				.version(appVersion));
	}
}