package com.example.demo.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private String isbn;
   
    private String titulo;
   
    @Column(name = "data_publicacao")
    private LocalDate dataPublicacao;
   
    private String genero;
  
    private BigDecimal preco;
   
    @JoinColumn(name = "id_autor")
    @ManyToOne
    private Autor autor;
}
