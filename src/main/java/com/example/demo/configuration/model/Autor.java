package com.example.demo.configuration.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "autor" )
public class Autor {
    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    private UUID id;

    @Column( nullable = false, length = 254 )
    private String nome;

    @Column( nullable = false)
    private LocalDate data_nascimento;

    @Column( nullable = false, length = 254 )
    private String nacionalidade;

    public Autor(){};

    public Autor( UUID id, 
                String nome, 
                LocalDate data_nascimento, 
                String nacionalidade ) {
        this.id = id;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.nacionalidade = nacionalidade;
    };

    public UUID getId() {
        return id;
    };

    public void setId(UUID id) {
        this.id = id;
    };

    public String getNome() {
        return nome;
    };

    public void setNome(String nome) {
        this.nome = nome;
    };

    public LocalDate getData_nascimento() {
        return data_nascimento;
    };

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    };

    public String getNacionalidade() {
      ;  return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    };


}
