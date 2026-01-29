package com.example.demo.configuration.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table( name = "livro")
public class Livro {
    private UUID id;
    private String isbn;
    private String titulo;
    @Column( name = "data_publicacao" )
    private LocalDate dataPublicação;
    private String genero = GeneroEnum.MISTERIO;


}
