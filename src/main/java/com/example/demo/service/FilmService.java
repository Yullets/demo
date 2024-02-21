package com.example.demo.service;

import com.example.demo.entity.Film;
import com.example.demo.entity.User;
import com.example.demo.entity.UserFilm;
import com.example.demo.repository.FilmRepository;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FilmService {

    private final FilmRepository fr;
    private final UserRepository ur;
//    private final GenreService gs;

//    public Film create(FilmDTO dto) {
//        Film f = Film.builder()
//                .name(dto.getName())
//                .genre(gs.findById(dto.getGenreId()))
//                .build();
//
//        return fr.save(f);
//    }

    public Page<Film> readAll() {
        Pageable p = PageRequest.of(0, 10);
        return fr.findAll(p);
    }

    public Page<Film> readAll(Pageable page) {
        return fr.findAll(page);
    }

    public List<Film> findByGenre(String genre) {
        Pageable p = PageRequest.of(1, 10);
        return fr.findByGenre(genre, p);
    }

    public List<Film> findAll(Long userId) {
        User user = ur.getReferenceById(userId);
        List<UserFilm> userFilms = user.getFilms();

        ArrayList<String> films = new ArrayList<>();
        for(UserFilm curElem: userFilms) {
            films.add(curElem.getFilmId().toString());
        }
        return (List<Film>) fr.findAll(films);
    }

//    public Film update(Film film) {
//        return fr.save(film);
//    }

//    public void delete(Long id) {
//        fr.deleteById(id);
//    }
}
