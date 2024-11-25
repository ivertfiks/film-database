package com.film.controller;

import com.film.client.MovieDatabaseHttpClient;
import com.film.entity.Movie;
import com.film.entity.MovieDetails;
import com.film.entity.Person;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping(value = {"/movie-list", "/movie-list/{search}/{page}"})
    public String getAllMovies(Model model,
                               @PathVariable(value = "search", required = false) String search,
                               @PathVariable(value = "page", required = false) Integer page) {
        List<Movie> movies;
        if (search != null && page != null) {
            movies = movieClient.getFilmsByWord(search, page);
        } else {
            movies = movieClient.getTopTrending();
        }
        model.addAttribute("movies", movies);
        return "anime_list";
    }

    @GetMapping("/movie_details/{id}")
    public String getMovieDetailsWithCredits(Model model, @PathVariable("id") String id) {
        MovieDetails movie = movieClient.getMovieDetails(id);
        model.addAttribute("movie", movie);
        List<Person> persons = movieClient.getMovieCredits(id);
        model.addAttribute("persons", persons);
        return "anime_details";
    }

    @GetMapping("/person_details/{id}")
    public String getCreditsById(Model model, @PathVariable("id") String id) {
        Person person = movieClient.getCreditById(id);
        model.addAttribute("person", person);
        return "person_details";
    }




//    @GetMapping("/movie/{id}")
//    public String getMovieDetails(@PathVariable("id") String id, Model model) {
//        Movie movie = movieClient.getMovieById(id);
//        model.addAttribute("movie", movie);
//        return "movie_detail";
//    }

}

