package com.film.entity.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.film.entity.MovieDetails;
import java.util.List;
import lombok.Data;

@Data
public class MovieDetailsResponse {

    @JsonProperty("results")
    private List<MovieDetails> movies;
}