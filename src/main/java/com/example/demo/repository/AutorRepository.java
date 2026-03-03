package com.example.demo.repository;

import com.example.demo.dto.AutorDTO;
import com.example.demo.model.Autor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {
    
    @Query("""
            select new com.example.demo.dto.AutorDTO(
                a.nome, 
                a.dataNascimento, 
                a.nacionalidade 
            ) 
            from Autor as a
            order by a.nome
            """)
    List<AutorDTO> listAllDto();
}
