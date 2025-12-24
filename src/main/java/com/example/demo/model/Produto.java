package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Produtos")
@Getter
@Setter
public class Produto {
    @Id
    @Column(name = "id")
    private String id;
    
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "descricao", nullable = false)
    private String descricao;
   
    @Column(name = "preco", nullable = false)
    private float preco;

    @Override
    public String toString(){
        return """
                id: %s
                nome: %s
                descrição: %s
                preço: %f
            
                """
                .formatted(id, nome, descricao, preco);
    }
}
