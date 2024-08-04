package com.movie.service;

import com.movie.config.MovieConfig;
import com.movie.local.MovieJsonReader;
import com.movie.repo.MovieRepo;
import com.movie.model.dao.Movie;
import com.movie.model.response.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieService {

    private MovieRepo movieRepo;

    private MovieJsonReader movieJsonReader;

    private MovieConfig movieConfig;

    @Autowired
    public MovieService(MovieRepo movieRepo, MovieJsonReader movieJsonReader, MovieConfig movieConfig) {
        this.movieRepo = movieRepo;
        this.movieJsonReader = movieJsonReader;
        this.movieConfig = movieConfig;
    }

    public List<MovieResponse> getAllMovies() {
        if (movieConfig.getType().equals("file")) {
            List<String> moviesList = movieJsonReader.get();
            return moviesList.stream().map(movie -> {
                String[] movieArray = movie.split("\\|");
                try {
                    return new MovieResponse(movieArray[0], Arrays.asList(movieArray[2].split("-")),
                            Integer.valueOf(movieArray[1]) == 0 ? null : Integer.valueOf(movieArray[1]));
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }).collect(Collectors.toList());
        }
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