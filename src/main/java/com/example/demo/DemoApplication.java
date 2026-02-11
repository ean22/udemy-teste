package com.example.demo;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.configuration.AutorRepository;
import com.example.demo.model.Autor;


@SpringBootApplication
@EnableConfigurationProperties
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

		AutorRepository autorRepository = context.getBean(AutorRepository.class);

		exemplo(autorRepository);
	}

	public static void exemplo(JpaRepository repository){
		Autor autor = new Autor();
		autor.setNome("Jorge");
		autor.setDataNascimento(LocalDate.of(1900, 12, 20));
		autor.setNacionalidade("Brasileiro");

		System.out.println(repository.save(autor));
	}

}
