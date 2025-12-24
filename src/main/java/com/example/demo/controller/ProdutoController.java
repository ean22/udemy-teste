package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping("/salvar")
    public Produto salvarProduto(@RequestBody Produto produto) {
        String id = UUID.randomUUID().toString();

        produto.setId(id);
        produtoRepository.save(produto);
        
        return produto;
    }

    @GetMapping("/")
    public List<Produto> listarProduto() {
        final List<Produto> produtos = produtoRepository.findAll();

        return produtos;
    }

    @GetMapping("/{id}")
    public Produto buscarIdProduto(@PathVariable String id){
        Optional<Produto> produto = produtoRepository.findById(id);

        if(produto.isPresent()){
            return produto.get();
        } else return null;
    }

    @PostMapping("/delete/{id}")
    public void deletarIdProdutos(@PathVariable String id){
        produtoRepository.deleteById(id);
    }
    
    
}
