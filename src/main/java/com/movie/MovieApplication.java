package com.movie;

import com.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = GsonAutoConfiguration.class)
@EnableMongoRepositories
public class MovieApplication implements CommandLineRunner {

    @Autowired
    private MovieService movieService;

    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(movieService.getByTitle("A Corner in Wheat"));
    }
}
