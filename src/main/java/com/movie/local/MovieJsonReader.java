package com.movie.local;

import com.movie.config.MovieConfig;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author bhargodev on 04/08/24
 **/
@Component
public class MovieJsonReader {

    private JSONArray movies;

    private ResourceLoader resourceLoader;

    private MovieConfig movieConfig;

    @Autowired
    public MovieJsonReader(ResourceLoader resourceLoader, MovieConfig movieConfig) {
        this.resourceLoader = resourceLoader;
        this.movieConfig = movieConfig;
    }

    @PostConstruct
    private void readFile() {
        try {
            Resource resource = resourceLoader.getResource("classpath:".concat(movieConfig.getName()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            String movieJson = bufferedReader.lines().collect(Collectors.joining());
            this.movies = new JSONArray(movieJson);
        } catch (IOException e) {
            System.out.println("Error while reading file " + e);
            throw new RuntimeException(e);
        }
    }

    public List<String> find(String searchKeyword) {
        List<String> result = new ArrayList<>();
        for(int i =0;i< movies.length();i++) {
            JSONObject movieJson = movies.getJSONObject(i);
            String title = (String)movieJson.get("title");
            if (title.contains(searchKeyword)) {
                result.add(title);
            }
        }
        return result;
    }

    public List<String> get() {
        List<String> result = new ArrayList<>();
        for(int i =0;i< movies.length();i++) {
            JSONObject movieJson = movies.getJSONObject(i);
            String title = null;
            Integer year= null;
            JSONArray genresArray = null;
            try {
                title = (String) movieJson.get("title");
                Object yearObj = movieJson.get("year");
                if (yearObj instanceof Integer) {
                    year = ((Integer) yearObj).intValue();
                } else {
                    year = Integer.valueOf(year.toString().substring(0, year.toString().length()));
                }
                if (movieJson.has("genres")) {
                    genresArray = movieJson.getJSONArray("genres");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Exception for " + title);
            }
            StringBuilder sb = new StringBuilder();
            if (genresArray != null) {
                for (int j =0; j<genresArray.length(); j++) {
                    sb.append(genresArray.get(j));
                    if (j+1 < genresArray.length()) {
                        sb.append("-");
                    }
                }
            }
            if (sb.length() ==0) {
                sb.append("No genres");
            }
            if (year == null) {
                year = 0;
            }
            result.add(title.concat("|").concat(year.toString()).concat("|").concat(sb.toString()));
        }
        return result;
    }
}
