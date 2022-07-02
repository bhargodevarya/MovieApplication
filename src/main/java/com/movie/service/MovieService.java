package com.movie.service;

import com.movie.repo.MovieRepo;
import com.movie.model.dao.Movie;
import com.movie.model.response.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieService {

    private MovieRepo movieRepo;

    @Autowired
    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    public List<MovieResponse> getAllMovies() {
        List<Movie> movies = movieRepo.findAll();
        return movies.stream()
                .map(movie -> new MovieResponse(movie.getTitle(), movie.getGenres(), movie.getYear()))
                .collect(Collectors.toList());
    }

    public MovieResponse getByTitle(String name) {
        Movie movie = movieRepo.findByTitle(name);
        return new MovieResponse(movie.getTitle(), movie.getGenres(),movie.getYear());
    }

    public Movie createMovie(Movie movie) {
        return movieRepo.save(movie);
    }
}