package com.example.demo.repository;

import com.example.demo.entity.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public interface FilmRepository {
    List<Film> findByGenre(String genre, Pageable pageable);

    Iterable<Film> findAll(Sort sort);

    Iterable<Film> findAll(ArrayList<String> ids);

    Page<Film> findAll(Pageable pageable);


}
