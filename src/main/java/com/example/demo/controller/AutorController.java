package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configuration.AutorRepository;
import com.example.demo.model.Autor;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/autor")
public class AutorController {
    AutorRepository autorRepo;

    AutorController(AutorRepository autorRepo) {
        this.autorRepo = autorRepo;
    }

    @PostMapping("/create")
    public ResponseEntity<Autor> save(@RequestBody Autor autor) {
        Autor autorSalvo = autorRepo.save(autor);        

        URI uri = URI.create("autor/list/" + autorSalvo.getId());
        
        return ResponseEntity.created(uri).body(autorSalvo);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Autor>> listAll() {
        return ResponseEntity.ok(autorRepo.findAll());
    }

    @GetMapping("/list/{uuid}")
    public ResponseEntity<Autor> listByUuid(@PathVariable UUID uuid) {
        return autorRepo.findById(uuid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity<String> delete(@PathVariable UUID uuid) {
        
        autorRepo.deleteById(uuid);
        return ResponseEntity.ok("Autor uuid: %s Deleted".formatted(uuid));
    }


    
}
