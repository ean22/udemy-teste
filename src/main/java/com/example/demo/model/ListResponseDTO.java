package com.example.demo.model;

import java.util.List;

public record ListResponseDTO<T>(int total, List<T> list) {
    
}

