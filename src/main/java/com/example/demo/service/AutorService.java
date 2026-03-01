package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AutorDTO;
import com.example.demo.model.Autor;
import com.example.demo.repository.AutorRepository;

@Service
public class AutorService {
    private final AutorRepository autorRepo;

    AutorService(AutorRepository autorRepo) {
        this.autorRepo = autorRepo;
    }

    public Autor save(AutorDTO autorDto) {
        Autor autor = new Autor();
        autor.setNome(autorDto.nome());
        autor.setDataNascimento(autorDto.dataNascimento());
        autor.setNacionalidade(autorDto.nacionalidade());

        return autorRepo.save(autor);
    }


}
