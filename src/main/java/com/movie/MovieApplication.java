package com.movie;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = {GsonAutoConfiguration.class, MongoAutoConfiguration.class})
//@EnableMongoRepositories
public class MovieApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(MovieApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        //System.out.println(movieService.getByTitle("A Corner in Wheat"));
    }
}
