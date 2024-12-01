package com.film.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.extern.slf4j.Slf4j;

@Data
@NoArgsConstructor
@Slf4j
@Entity
public class Movie {

    @Id
    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("original_title")
    private String originalTitle;

    @JsonProperty("overview")
    private String overview;

    @JsonProperty("poster_path")
    private String posterPath;

    @JsonProperty("backdrop_path")
    private String backdropPath;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("vote_average")
    private double voteAverage;

    @JsonProperty("vote_count")
    private int voteCount;

    @JsonProperty("popularity")
    private double popularity;

    @JsonProperty("genre_ids")
    private int[] genreIds;

    @JsonProperty("adult")
    private boolean adult;

    @JsonProperty("original_language")
    private String originalLanguage;

    @JsonProperty("media_type")
    private String mediaType;

    private String releaseYear;

    @JsonSetter("release_date")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        if (releaseDate == null || releaseDate.isEmpty()) {
            this.releaseYear = "N/A";
            return;
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(releaseDate, formatter);
            this.releaseYear = String.valueOf(date.getYear());
        } catch (Exception e) {
            log.warn("Invalid date format: {}", releaseDate);
        }
    }

    @JsonProperty("total_pages")
    private static int totalPages;

    @JsonProperty("total_results")
    private static int totalResults;

}
