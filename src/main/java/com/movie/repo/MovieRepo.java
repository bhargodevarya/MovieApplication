package com.movie.repo;

import com.movie.model.dao.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepo extends MongoRepository<Movie, String> {
    Movie findByTitle(String name);
}
