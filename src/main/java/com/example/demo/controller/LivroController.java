package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ListResponseDTO;
import com.example.demo.model.Livro;
import com.example.demo.model.Autor;
import com.example.demo.repository.AutorRepository;
import com.example.demo.repository.LivroRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/livro")
public class LivroController {
    AutorRepository autorRepo;
    LivroRepository livroRepo;

    LivroController(AutorRepository autorRepo, LivroRepository livroRepo) {
        this.autorRepo = autorRepo;
        this.livroRepo = livroRepo;
    }
    
    @PostMapping("/{uuid}")
    public ResponseEntity<?> save(@PathVariable UUID uuid ,@RequestBody Livro livro) {    
        Optional<Autor> optionalAutor = autorRepo.findById(uuid);

        if (optionalAutor.isPresent()) {
            Autor autor = optionalAutor.get();
            
            livro.setAutor(autor);

            Livro saved = livroRepo.save(livro);
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

    @GetMapping()
    public ResponseEntity<ListResponseDTO<Livro>> listAll() {
        List<Livro> livroList = livroRepo.findAll();
        ListResponseDTO<Livro> response = new ListResponseDTO<>(livroList.size(), livroList);

        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{uuid}")
    public ResponseEntity<Livro> listByUuid(@PathVariable UUID uuid) {
    
        return livroRepo.findById(uuid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("autor/{uuid}")
    public ResponseEntity<List<Livro>> listByAutor(@PathVariable UUID uuid) {

        return autorRepo.findById(uuid)
                .map(autor -> ResponseEntity.ok(livroRepo.findByAutor(autor)))
                .orElse(ResponseEntity.notFound().build());  
        
    }
    

    @PutMapping("/{uuid}")
    public ResponseEntity<Livro> update(@PathVariable UUID uuid, @RequestBody Livro livro) {
        Optional<Livro> optionalLivro = livroRepo.findById(uuid);

        if (optionalLivro.isPresent()) {
            Livro updatedLivro = optionalLivro.get();

            updatedLivro.setIsbn(livro.getIsbn());
            updatedLivro.setPreco(livro.getPreco());
            updatedLivro.setTitulo(livro.getTitulo());
            updatedLivro.setGenero(livro.getGenero());
            updatedLivro.setDataPublicacao(livro.getDataPublicacao());

            return ResponseEntity.ok(livroRepo.save(updatedLivro));
        }
        
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<String> deleteByUuid(@PathVariable UUID uuid) {
        livroRepo.deleteById(uuid);

        return ResponseEntity.ok("Livro uuid: %s Deleted".formatted(uuid));
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteAll() {
        livroRepo.deleteAll();

        return ResponseEntity.ok("All Livros Deleted");
    }
}
