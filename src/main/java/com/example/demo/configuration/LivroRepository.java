package com.example.demo.configuration;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, UUID>{
    
}
