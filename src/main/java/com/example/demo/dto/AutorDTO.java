package com.example.demo.dto;

import java.time.LocalDate;
import java.util.UUID;

public record AutorDTO(UUID id, 
        String nome, 
        LocalDate dataNascimento, 
        String nacionalidade) {
    
    public AutorDTO(String nome, LocalDate dataNascimento, String nacionalidade) {
        this(null, nome, dataNascimento, nacionalidade);
    }
}
