package com.example.demo.dto;

import java.util.List;

public record ListResponseDTO<T>(int total, List<T> list) {
    
}

