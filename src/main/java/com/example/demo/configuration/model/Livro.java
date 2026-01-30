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
    private String genero;
    private Double preco;
    private Autor autor;

    public Livro() {};

    public Livro( UUID id,
                String isbn,
                String titulo, 
                LocalDate dataPublicação,
                String genero,
                Double preco,                
                Autor autor ) {

        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.dataPublicação = dataPublicação;
        this.genero = genero;
        this.preco = preco;
        this.autor = autor;
    };

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataPublicação() {
        return dataPublicação;
    }

    public void setDataPublicação(LocalDate dataPublicação) {
        this.dataPublicação = dataPublicação;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    

}
