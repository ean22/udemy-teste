package com.example.demo.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dto.AutorDTO;
import com.example.demo.model.Autor;

@Component
public class AutorMapper {
    public Autor toAutor(AutorDTO autorDto) {
        Autor autor = new Autor();
        autor.setNome(autorDto.nome());
        autor.setDataNascimento(autorDto.dataNascimento());
        autor.setNacionalidade(autorDto.nacionalidade());

        return autor;
    }

    public AutorDTO toDto(Autor autor) {
        return new AutorDTO(autor.getNome(),
                autor.getDataNascimento(),
                autor.getNacionalidade());
    }
}
