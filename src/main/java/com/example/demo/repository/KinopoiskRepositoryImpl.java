package com.example.demo.repository;

import com.example.demo.entity.Film;
import com.example.demo.model.ArrayFilm;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

 class Doc{
    public int id;
    public String name;
    public int year;
}

 class Root{
    public ArrayList<Doc> docs;
    public int total;
    public int limit;
    public int page;
    public int pages;
}

@Component
public class KinopoiskRepositoryImpl implements FilmRepository {
    private final String BASE_ADDRESS = "https://api.kinopoisk.dev/v1.4";
    private final OkHttpClient client = new OkHttpClient();
    private final String authorization = "EJGA897-2C7MZ98-QD6C5V1-7N2TBTJ";

    @Override
    public List<Film> findByGenre(String genre, Pageable pageable) {
        String requestUrl = String.format("%s/movie?page=%d&limit=%d&genres.name=%s", BASE_ADDRESS, pageable.getPageNumber(), pageable.getPageSize(), genre);
        Request request = new Request.Builder()
                .url(requestUrl)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("X-API-KEY", authorization)
                .build();

        ArrayFilm films = new ArrayFilm();
        Response response = null;

        try {
            response = client.newCall(request).execute();

            // parse response to Films
            ObjectMapper om = new ObjectMapper();
            films = om.readValue(response.body().string(), ArrayFilm.class);

            response.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            response.close();
        }

        return films.getDocs();
    }

    @Override
    public Iterable<Film> findAll(Sort sort) {
        return null;
    }

    @Override
    public Iterable<Film> findAll(ArrayList<String> ids) {
        String requestUrl = String.format("%s/movie?selectFields=", BASE_ADDRESS);

        for(String id: ids) {
            requestUrl = String.format("%s&id=%s", requestUrl, id);
        }

        Request request = new Request.Builder()
                .url(requestUrl)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("X-API-KEY", authorization)
                .build();

        ArrayFilm films = new ArrayFilm();
        Response response = null;

        try {
            response = client.newCall(request).execute();

            // parse response to Films
            ObjectMapper om = new ObjectMapper();
            films = om.readValue(response.body().string(), ArrayFilm.class);

            response.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            response.close();
        }

        return films.getDocs();
    }

    @Override
    public Page<Film> findAll(Pageable pageable) {
        String requestUrl = String.format("%s/movie?page=%d&limit=%d", BASE_ADDRESS, pageable.getPageNumber(), pageable.getPageSize());
        Request request = new Request.Builder()
                .url(requestUrl)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("X-API-KEY", authorization)
                .build();

        ArrayFilm films = new ArrayFilm();
        Response response = null;

        try {
            response = client.newCall(request).execute();

            // parse response to Films
            ObjectMapper om = new ObjectMapper();
            films = om.readValue(response.body().string(), ArrayFilm.class);

            response.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            response.close();
        }

        return new PageImpl<>(films.getDocs(), pageable, films.getDocs().size());
    }
}
