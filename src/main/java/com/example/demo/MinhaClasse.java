package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MinhaClasse {

    @Value("${teste.variavel}")
    private String appPropertiesVariavel;

    public String imprimir() {
        
        return 
        """
        Existo:
        %s

        """.formatted(appPropertiesVariavel);
    }
    
    
}
