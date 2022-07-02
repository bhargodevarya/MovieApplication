package com.movie;

import com.movie.model.dao.Movie;
import com.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class MovieApplication implements CommandLineRunner {

    @Autowired
    private MovieService movieService;

    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        Movie movie = movieService.createMovie(new Movie("added", List.of("Comedy"), 2022));
        System.out.println(movie);
    }
}
