package com.github.ean22.udemy_teste.teste.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.ean22.udemy_teste.teste.model.Produto;

@RestController
@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    
    
    @PostMapping("/salvar")
    public String salvarProduto(@RequestBody Produto produto){
        return "Produto salvo: " + produto;
    }

}
