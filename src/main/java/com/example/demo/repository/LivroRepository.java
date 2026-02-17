package com.example.demo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Livro;
import com.example.demo.model.Autor;

public interface LivroRepository extends JpaRepository<Livro, UUID>{
    List<Livro> findByAutor(Autor autor);
}
