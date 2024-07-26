package com.movie.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "movie")
public class MovieAPI {

    @RequestMapping(method = RequestMethod.GET, path = "hello")
    public String hello() {
        return "hello";
    }
}
