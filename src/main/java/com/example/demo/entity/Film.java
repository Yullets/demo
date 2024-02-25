package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private Long id;
    private String name;
    private int year;
    private ArrayList<Genre> genres;
    private ArrayList<Country> countries;
    private int ageRating;
    private String shortDescription;
    private Poster poster;
}


@JsonIgnoreProperties(ignoreUnknown = true)
class Poster {
    public String url;
}