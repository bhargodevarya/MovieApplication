package com.movie.api;

import com.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "movie")
public class MovieAPI {

    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.GET, path = "hello")
    public String hello() {
        return "hello";
    }
}
