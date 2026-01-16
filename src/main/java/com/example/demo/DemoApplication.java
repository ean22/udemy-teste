package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableConfigurationProperties
public class DemoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DemoApplication.class, args);

		// builder da aplicação
		SpringApplicationBuilder builder = new SpringApplicationBuilder(DemoApplication.class);
		builder.profiles();
		builder.lazyInitialization(false);
		builder.bannerMode(Mode.OFF);
		builder.run(args);
		
		// contexto da aplicação iniciada
		ConfigurableApplicationContext applicationContext = builder.context();
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		System.out.println(environment.getProperty("teste.variavel"));
		System.out.println("Busanfa: " + environment.getDefaultProfiles());

		MinhaClasse minhaClasse = applicationContext.getBean(MinhaClasse.class);
		System.out.println(minhaClasse.imprimir());

		OutraClasse outraClasse = applicationContext.getBean(OutraClasse.class);
		outraClasse.imprimir();

		MinhasPropriedades minhasPropriedades = applicationContext.getBean(MinhasPropriedades.class);
		System.out.println(minhasPropriedades.getNome());
		System.out.println(minhasPropriedades.getNumero());
		System.out.println(minhasPropriedades.isBool());
	
	}

}
