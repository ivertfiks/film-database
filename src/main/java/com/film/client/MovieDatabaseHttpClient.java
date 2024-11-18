package com.film.client;

import com.film.entity.Movie;
import com.film.entity.MovieDbEndpoints;
import com.film.entity.MovieResponse;
import jakarta.annotation.PostConstruct;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieDatabaseHttpClient {

    private final WebClient restClient;

    @Value("${moviedb.access-token}")
    private String accessToken;

    @Value("${moviedb.base-url}")
    private String baseUrl;


    public List<Movie> getTopTrending() {
        try {
            return restClient.get()
                .uri(uriBuilder -> uriBuilder
                    .path(MovieDbEndpoints.GET_TOP_TRENDING_MOVIES)
                    .queryParam("language", "en-US")
                    .build())
                .header("Authorization", "Bearer " + accessToken)
                .header("accept", "application/json")
                .retrieve()
                .bodyToFlux(Movie.class)
                .collectList()
                .block();
        } catch (WebClientResponseException ex) {
            // Log the error or handle it as needed
            log.info("exception");
            throw new RuntimeException("Failed to fetch movie data", ex);
        }
    }



    public String getTopTrendingString() {
        try {
            return restClient.get()
                .uri(uriBuilder -> uriBuilder
                    .path(MovieDbEndpoints.GET_TOP_TRENDING_MOVIES)
                    .queryParam("language", "en-US")
                    .build())
                .header("Authorization", "Bearer " + accessToken)
                .header("accept", "application/json")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        } catch (WebClientResponseException ex) {
            // Log the error or handle it as needed
            log.info("exception");
            throw new RuntimeException("Failed to fetch movie data", ex);
        }
    }
}
