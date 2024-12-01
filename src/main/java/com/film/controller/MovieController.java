package com.film.controller;

import com.film.client.MovieDatabaseHttpClient;
import com.film.entity.Movie;
import com.film.entity.MovieDetails;
import com.film.entity.Person;
import com.film.entity.responses.MovieResponse;
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
    public String getTopTrendingMovies(Model model, @PathVariable(value = "page", required = false) Integer page) {
        if(page == null) page = 1;
        MovieResponse movies = movieClient.getTopTrending(page);
        model.addAttribute("movies", movies.getMovies());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", movies.getTotalPages());
        model.addAttribute("totalResults", movies.getTotalResults());
        return "index";
    }

    @GetMapping(value = {"/movie-list", "/movie-list/{search}/{page}", "/movie-list/{page}"})
    public String getAllMovies(Model model,
                               @PathVariable(value = "search", required = false) String search,
                               @PathVariable(value = "page", required = false) Integer page) {
        MovieResponse movieResponse;
        if(page == null) page = 1;
        if (search != null) {
            movieResponse = movieClient.getFilmsByWord(search, page);
        } else {
            movieResponse = movieClient.getTopTrending(page);
        }
        log.info("Movies size: " + movieResponse.getTotalResults());
        model.addAttribute("movies", movieResponse.getMovies());
        model.addAttribute("search", search);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", movieResponse.getTotalPages());
        model.addAttribute("totalResults", movieResponse.getTotalResults());
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

