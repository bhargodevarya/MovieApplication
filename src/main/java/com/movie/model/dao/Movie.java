package com.movie.model.dao;

import java.util.List;

public class Movie {
    private String title;
    private List<String> genres;
    private int year;

    public String getTitle() {
        return title;
    }

    public List<String> getGenres() {
        return genres;
    }

    public int getYear() {
        return year;
    }
}
