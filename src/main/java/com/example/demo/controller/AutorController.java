package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Autor;
import com.example.demo.model.AutorDTO;
import com.example.demo.model.ListResponseDTO;
import com.example.demo.repository.AutorRepository;

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
@RequestMapping("/autores")
public class AutorController {
    AutorRepository autorRepo;

    AutorController(AutorRepository autorRepo) {
        this.autorRepo = autorRepo;
    }

    @PostMapping()
    public ResponseEntity<String> salvar(@RequestBody AutorDTO autor) {


        return ResponseEntity.created(null).body("null");
    }
}















// public class AutorController {
//     AutorRepository autorRepo;

//     AutorController(AutorRepository autorRepo) {
//         this.autorRepo = autorRepo;
//     }

//     @PostMapping("/save")
//     public ResponseEntity<Autor> save(@RequestBody Autor autor) {
//         Autor autorSalvo = autorRepo.save(autor);        

//         URI uri = URI.create("autor/list/" + autorSalvo.getId());
        
//         return ResponseEntity.created(uri).body(autorSalvo);
//     }

//     @GetMapping("/list")
//     public ResponseEntity<ListResponseDTO<Autor>> listAll() {
//         List<Autor> autorList = autorRepo.findAll();
//         ListResponseDTO<Autor> response = new ListResponseDTO<>(autorList.size(), autorList);

//         return ResponseEntity.ok(response);
//     }

//     @GetMapping("/list/{uuid}")
//     public ResponseEntity<Autor> listByUuid(@PathVariable UUID uuid) {
//         return autorRepo.findById(uuid)
//                 .map(ResponseEntity::ok)
//                 .orElse(ResponseEntity.notFound().build());
//     }

//     @DeleteMapping("/delete/{uuid}")
//     public ResponseEntity<String> deleteByUuid(@PathVariable UUID uuid) {
//         autorRepo.deleteById(uuid);

//         return ResponseEntity.ok("Autor uuid: %s Deleted".formatted(uuid));
//     }

//     @DeleteMapping("/delete")
//     public ResponseEntity<String> deleteAll() {
//         autorRepo.deleteAll();
        
//         return ResponseEntity.ok("All Autors Deleted");
//     }

//     @PutMapping("/update/{uuid}")
//     public ResponseEntity<Autor> update(@PathVariable UUID uuid, @RequestBody Autor autor) {
//         Optional<Autor> optionalAutor = autorRepo.findById(uuid);

//         if (optionalAutor.isPresent()) {
//             Autor updatedAutor = optionalAutor.get();

//             updatedAutor.setNome(autor.getNome());
//             updatedAutor.setDataNascimento(autor.getDataNascimento());
//             updatedAutor.setNacionalidade(autor.getNacionalidade());
            
//             return ResponseEntity.ok(autorRepo.save(updatedAutor));
//         } else return ResponseEntity.notFound().build();
        
//     }
    
// }

