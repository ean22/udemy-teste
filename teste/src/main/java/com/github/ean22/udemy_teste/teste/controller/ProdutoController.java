package com.github.ean22.udemy_teste.teste.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.ean22.udemy_teste.teste.model.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    Produto produto = new Produto();
    
    @GetMapping("/salvar")
    public String salvarProduto(){
        return "Produto salvo: " + produto.toString();
    }
}
