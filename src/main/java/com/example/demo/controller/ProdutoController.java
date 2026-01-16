package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;





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
        System.out.println(HttpStatus.ACCEPTED);
        return produto;
    }

    @GetMapping("/")
    public List<Produto> listarProduto() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produto buscarIdProduto(@PathVariable String id){
        return produtoRepository.findById(id)
        .orElse(null);
    }

    @GetMapping("/nome")
    public List<Produto> buscarNomeProduto(@RequestParam("nome") String nome) {
        return produtoRepository.findByNome(nome);
    }
    

    @DeleteMapping("{id}")
    public void deletarIdProduto(@PathVariable String id){
        produtoRepository.deleteById(id);
    }
    
    @PutMapping("{id}")
    public void atualizarIdProduto(@PathVariable String id, @RequestBody Produto produto) {
        Optional<Produto> produtoBanco = produtoRepository.findById(id);
        
        if(produtoBanco.isPresent()){
            produto.setId(id);

            produtoRepository.save(produto);
        }
    }
}
