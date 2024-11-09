package com.film.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class Movie {

    private String id;
    @JsonProperty("backdrop_path")
    private String backdropPath;

    private String title;

    @JsonProperty("original_title")
    private String originalTitle;
    private String overview;
    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("media_type")
    private String mediaType;

    private boolean adult;

    @JsonProperty("original_language")
    private String originalLanguage;

    @JsonProperty("genre_ids")
    private List<Integer> genreIds;

    private double popularity;

    @JsonProperty("release_date")
    private String releaseDate;

    private boolean video;

    @JsonProperty("vote_average")
    private double voteAverage;

    @JsonProperty("vote_count")
    private int voteCount;
}
