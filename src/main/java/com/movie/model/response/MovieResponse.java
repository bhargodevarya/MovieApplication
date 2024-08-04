package com.movie.model.response;

import java.util.List;

public class MovieResponse {

    private String title;
    private int year;
    private List<String> genres;
    public MovieResponse(String title, List<String> genres, int year) {
        this.title = title;
        this.genres = genres;
        this.year = year;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", genres=" + genres +
                '}';
    }
}


