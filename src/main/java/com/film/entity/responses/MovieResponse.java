package com.film.entity.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.film.entity.Movie;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse {

    @JsonProperty("results")
    private List<Movie> movies;

    @JsonProperty("total_pages")
    private int totalPages;

    @JsonProperty("total_results")
    private int totalResults;
}