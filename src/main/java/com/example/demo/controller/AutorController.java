package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configuration.AutorRepository;
import com.example.demo.model.Autor;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/autor")
public class AutorController {
    AutorRepository autorRepo;

    AutorController(AutorRepository autorRepo) {
        this.autorRepo = autorRepo;
    }



    @PostMapping("/create")
    public ResponseEntity<Autor> save(@RequestParam Autor autor) {
        Autor autorSalvo = autorRepo.save(autor);        

        URI uri = URI.create("autor/list/" + autorSalvo.getId());
        
        return ResponseEntity.created(uri).body(autorSalvo);
    }

    
    @GetMapping
    public ResponseEntity<List<Autor>> listAll() {
        return ResponseEntity.ok(autorRepo.findAll());
    }
    
}
