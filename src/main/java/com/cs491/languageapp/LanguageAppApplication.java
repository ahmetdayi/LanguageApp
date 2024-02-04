package com.cs491.languageapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.print.Doc;


@SpringBootApplication()

public class LanguageAppApplication {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
	public static void main(String[] args) {

		SpringApplication.run(LanguageAppApplication.class, args);


		//Service, RestController,Repository,Component Service controllera dönmek için yazılır component classa dönmesi için yazılır controllera dönen şey api olarak çalışır
	}


}
