package com.example.demo.service;

import com.example.demo.entity.Genre;
import com.example.demo.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GenreService {

    private final GenreRepository gr;

    public List<Genre> realAll() {
        return gr.findAll();
    }

    public Genre findById(Long id) {
        return gr.findById(id).orElseThrow(() -> new RuntimeException("Genre is not found"));
    }
}
