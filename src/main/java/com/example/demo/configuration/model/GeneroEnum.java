package com.example.demo.configuration.model;

public enum GeneroEnum {
    FICCAO("ficção"),
    FANTASIA("fantasia"),
    MISTERIO("misterio");

    public final String value;

    private GeneroEnum( String value ){
        this.value = value;
    }
}
