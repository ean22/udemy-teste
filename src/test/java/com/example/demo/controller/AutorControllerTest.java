package com.example.demo.controller;

import com.example.demo.model.Autor;
import com.example.demo.repository.AutorRepository;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AutorControllerTest {
    @Autowired
    AutorController autorController;

    @Test
    public void createAutorTeste() {
        Autor autor = new Autor();
        autor.setNome("Jorge");
        autor.setDataNascimento(LocalDate.of(1999, 12, 1));
        autor.setNacionalidade("Austria");

        autorController.save(autor);
    }

    @Test
    public void listAutorTest(){
        autorController.listAll().getBody();
    }
}
