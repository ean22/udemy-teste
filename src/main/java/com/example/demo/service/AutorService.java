package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AutorDTO;
import com.example.demo.dto.ListResponseDTO;
import com.example.demo.mapper.AutorMapper;
import com.example.demo.model.Autor;
import com.example.demo.repository.AutorRepository;

import java.util.Optional;
import java.util.UUID;

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

    public ListResponseDTO<AutorDTO> listAllDto() {
        return new ListResponseDTO<AutorDTO>(
                autorRepo.listAllDto().size(),
                autorRepo.listAllDto());
    }

    public Optional<AutorDTO> findDtoByUuid(UUID uuid) {
        return autorRepo.findDtoById(uuid);
    }

}
