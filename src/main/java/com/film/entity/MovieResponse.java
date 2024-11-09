package com.film.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class MovieResponse {

    @JsonProperty("results")
    private List<Movie> movies;
}