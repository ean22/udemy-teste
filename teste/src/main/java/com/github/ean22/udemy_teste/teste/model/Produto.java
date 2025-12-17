package com.github.ean22.udemy_teste.teste.model;

public class Produto {
    private String nome;
    private String descricao;
    private double preco;

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco(){
        return preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }    
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // @Override
    // public String toString() {
        
    //     return super.toString();
    // }

}
