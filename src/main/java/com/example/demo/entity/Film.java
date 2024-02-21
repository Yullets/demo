package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "film_id")
    private Long id;
    private String name;
    private int year;
    @OneToMany
    @JoinColumn(name = "film_id")
    private ArrayList<Genre> genres;
    @OneToMany
    @JoinColumn(name = "film_id")
    private ArrayList<Country> countries;
    private int ageRating;
    private String shortDescription;
    //    @ManyToMany
//    private Set<User> users = new HashSet<>();
    private Poster poster;
}


@JsonIgnoreProperties(ignoreUnknown = true)
class Poster {
    public String url;
}