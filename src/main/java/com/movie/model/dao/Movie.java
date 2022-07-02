package com.movie.model.dao;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Movie {
    private String title;
    private List<String> genres;
    private int year;

    public Movie(String title, List<String> genres, int year) {
        this.title = title;
        this.genres = genres;
        this.year = year;
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public List<String> getGenres() {
        return genres;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genres=" + genres +
                ", year=" + year +
                '}';
    }
}
