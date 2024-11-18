package com.film.controller;

import com.film.client.MovieDatabaseHttpClient;
import com.film.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor
public class MovieController {

    private final MovieDatabaseHttpClient movieClient;

    @GetMapping(value = {"/movies", "/"})
    public String getTopTrendingMovies(Model model) {
        List<Movie> movies = movieClient.getTopTrending();
        model.addAttribute("movies", movies);
        return "index";
    }

//    @GetMapping("/movie/{id}")
//    public String getMovieDetails(@PathVariable("id") String id, Model model) {
//        Movie movie = movieClient.getMovieById(id);
//        model.addAttribute("movie", movie);
//        return "movie_detail";
//    }
}

