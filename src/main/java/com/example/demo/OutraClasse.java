package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OutraClasse {
    private int num;

    public OutraClasse(@Value("${testeDependencia.variavel}") Integer num){
        this.num = num;
    }

    public void imprimir(){
        System.out.println("valor da dependencia: " + num);
    }
}
