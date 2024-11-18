package com.film.entity.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.film.entity.Movie;
import java.util.List;
import lombok.Data;

@Data
public class MovieResponse {

    @JsonProperty("results")
    private List<Movie> movies;
}