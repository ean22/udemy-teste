package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AutorDTO;
import com.example.demo.dto.ListResponseDTO;
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

    // public ListResponseDTO<Autor> listAll() {
    //     ListResponseDTO<AutorDTO> list = new ListResponseDTO<>();
        
    //     List<Autor> listAutor = autorRepo.findAll();
    // }

}
