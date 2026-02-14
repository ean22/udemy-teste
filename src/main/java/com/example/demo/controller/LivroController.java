package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ListResponseDTO;
import com.example.demo.model.Livro;
import com.example.demo.model.Autor;
import com.example.demo.repository.AutorRepository;
import com.example.demo.repository.LivroRepository;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/livro")
public class LivroController {
    AutorRepository autorRepository;
    LivroRepository livroRepository;

    LivroController(AutorRepository autorRepository, LivroRepository livroRepository) {
        this.autorRepository = autorRepository;
        this.livroRepository = livroRepository;
    }
    
    @PostMapping("/save/{uuid}")
    public ResponseEntity<?> save(@PathVariable UUID uuid ,@RequestBody Livro livro) {    
        Optional<Autor> optionalAutor = autorRepository.findById(uuid);

        if (optionalAutor.isPresent()) {
            Autor autor = optionalAutor.get();
            
            livro.setAutor(autor);

            Livro saved = livroRepository.save(livro);
            URI uri = URI.create("/livro/list/" + saved.getId());
            livro.setAutor(autor);

            return ResponseEntity
                    .created(uri)
                    .body(saved);
        } else {
            URI uri = URI.create("/autor/list/" + uuid);
            
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Autor not found. path:" + uri);
        }

    }

}
