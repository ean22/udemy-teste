package com.example.demo.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(nullable = false)
    private String isbn;
   
    @Column(nullable = false)
    private String titulo;
   
    @Column(name = "data_publicacao", nullable = false)
    private LocalDate dataPublicacao;
   
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GeneroEnum genero;
  
    @Column(precision = 18, scale = 2)
    private BigDecimal preco;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @Column(name = "id_usuario")
    private UUID idUsuario;
  
    @JoinColumn(name = "id_autor", nullable = false)
    @ManyToOne()
    private Autor autor;
}
