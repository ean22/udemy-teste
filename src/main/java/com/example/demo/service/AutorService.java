package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AutorDTO;
import com.example.demo.mapper.AutorMapper;
import com.example.demo.model.Autor;
import com.example.demo.repository.AutorRepository;

@Service
public class AutorService {
    private final AutorRepository autorRepo;
    private final AutorMapper autorMapper;

    AutorService(AutorRepository autorRepo, AutorMapper autorMapper) {
        this.autorRepo = autorRepo;
        this.autorMapper = autorMapper;
    }

    public Autor save(AutorDTO autorDto) {
        return autorRepo.save(autorMapper.toAutor(autorDto));
    }


}
