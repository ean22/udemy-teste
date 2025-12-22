package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private float preco;

    @Override
    public String toString(){
        return """
                id: %d
                nome: %s
                descrição: %s
                preço: %f
            
                """
                .formatted(id, nome, descricao, preco);
    }
}
