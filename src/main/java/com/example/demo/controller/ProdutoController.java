package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping("/salvar")
    public String salvarProduto(@RequestBody Produto produto) {
        String id = UUID.randomUUID().toString();

        produto.setId(id);
        produtoRepository.save(produto);
        
        return produto.toString();
    }

    @GetMapping("/")
    public List<Produto> getMethodName() {
        List<Produto> produtos = produtoRepository.findAll();

        return produtos;
    }
    
    
}
