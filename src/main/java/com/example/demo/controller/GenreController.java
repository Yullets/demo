package com.example.demo.controller;

import com.example.demo.entity.Genre;
import com.example.demo.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genres")
@AllArgsConstructor
public class GenreController {

    private final GenreService gs;

    @GetMapping
    public ResponseEntity<List<Genre>> readAll() {
        return new ResponseEntity<>(gs.realAll(), HttpStatus.OK);
    }
}
