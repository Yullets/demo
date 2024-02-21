package com.example.demo.controller;

import com.example.demo.entity.Film;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.FilmService;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/films")
@AllArgsConstructor
public class FilmController {

    private final FilmService fs;
    private final UserServiceImpl us;

//    @PostMapping
//    public ResponseEntity<Film> create(@RequestBody FilmDTO dto) {
//        return mappingResponseFilm(fs.create(dto));
//    }

    @GetMapping("/all")
    public ResponseEntity<Page<Film>> findAll() {
        PageRequest page = PageRequest.of(1,10);
        return new ResponseEntity<>(fs.readAll(page), HttpStatus.OK);
//        return mappingResponseListFilm(fs.readAll());
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Film>> findByGenreId(@PathVariable String genre) {
        return mappingResponseListFilm(fs.findByGenre(genre));
    }

    @GetMapping("/saved")
    public ResponseEntity<List<Film>> findSaved() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = (User) us.loadUserByUsername(userDetails.getUsername());
        return new ResponseEntity<>(fs.findAll(user.getId()), HttpStatus.OK);
    }

//    @PutMapping
//    public ResponseEntity<Film> update(@RequestBody Film film) {
//        return mappingResponseFilm(fs.update(film));
//    }

//    @DeleteMapping("/{id}")
//    public HttpStatus delete(@PathVariable Long id) {
//        fs.delete(id);
//        return HttpStatus.OK;
//    }

    private ResponseEntity<List<Film>> mappingResponseListFilm(List<Film> films) {
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    private ResponseEntity<Film> mappingResponseFilm(Film film) {
        return new ResponseEntity<>(film, HttpStatus.OK);
    }
}
