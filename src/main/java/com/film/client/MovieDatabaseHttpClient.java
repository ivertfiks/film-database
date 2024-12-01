package com.film.client;

import com.film.entity.Movie;
import com.film.client.endpoints.MovieDbEndpoints;
import com.film.entity.MovieDetails;
import com.film.entity.Person;
import com.film.entity.responses.MovieResponse;
import java.util.List;

import com.film.entity.responses.PersonDetailsResponse;
import com.film.entity.responses.PersonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import static com.film.client.endpoints.MovieDbEndpoints.GET_MOVIES_BY_WORD;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieDatabaseHttpClient {

    private final WebClient restClient;

    @Value("${moviedb.access-token}")
    private String accessToken;

    @Value("${moviedb.base-url}")
    private String baseUrl;

    public MovieResponse getTopTrending(int page) {
        try {
            return restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path(MovieDbEndpoints.GET_TOP_TRENDING_MOVIES)
                            .queryParam("page", page)
                            .queryParam("language", "en-US")
                            .build())
                    .header("Authorization", "Bearer " + accessToken)
                    .header("accept", "application/json")
                    .retrieve()
                    .bodyToMono(MovieResponse.class)
                    .block();
        } catch (WebClientResponseException ex) {
            log.error("Failed to fetch trending movies. Status code: {}", ex.getStatusCode());
            log.error("Error message: {}", ex.getResponseBodyAsString());
            throw new RuntimeException("Failed to fetch movie data", ex);
        }
    }

    public MovieResponse getFilmsByWord(String keyword, int page) {
        try {
            return restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path(GET_MOVIES_BY_WORD)
                            .queryParam("query", keyword)
                            .queryParam("page", page)
                            .queryParam("language", "en-US")
                            .build())
                    .header("Authorization", "Bearer " + accessToken)
                    .header("accept", "application/json")
                    .retrieve()
                    .bodyToMono(MovieResponse.class)
                    .block();
        } catch (WebClientResponseException ex) {
            log.error("Failed to fetch searched movies. Status code: {}", ex.getStatusCode());
            log.error("Error message: {}", ex.getResponseBodyAsString());
            throw new RuntimeException("Failed to fetch movie data", ex);
        }
    }

    public List<Person> getMovieCredits(String id) {
        try {
            return restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path(MovieDbEndpoints.GET_MOVIE_CREDITS_BY_ID)
                            .queryParam("language", "en-US")
                            .build(id))
                    .header("Authorization", "Bearer " + accessToken)
                    .header("accept", "application/json")
                    .retrieve()
                    .bodyToMono(PersonResponse.class)
                    .map(PersonResponse::getPersons)
                    .block();
        } catch (WebClientResponseException ex) {
            log.error("Failed to fetch movie credits for id: {}. Status code: {}", id, ex.getStatusCode());
            log.error("Error message: {}", ex.getResponseBodyAsString());
            throw new RuntimeException("Failed to fetch movie data", ex);
        }
    }

    public Person getCreditById(String id) {
        try {
            return restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path(MovieDbEndpoints.GET_CREDIT_BY_ID)
                            .queryParam("language", "en-US")
                            .build(id))
                    .header("Authorization", "Bearer " + accessToken)
                    .header("accept", "application/json")
                    .retrieve()
                    .bodyToMono(Person.class)
                    .block();
        } catch (WebClientResponseException ex) {
            log.error("Failed to fetch credit for id: {}. Status code: {}", id, ex.getStatusCode());
            log.error("Error message: {}", ex.getResponseBodyAsString());
            throw new RuntimeException("Failed to fetch movie data", ex);
        }
    }



    public MovieDetails getMovieDetails(String id) {
        try {
            return restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path(MovieDbEndpoints.GET_MOVIE_DETAILS_BY_ID)
                            .queryParam("language", "en-US")
                            .build(id))
                    .header("Authorization", "Bearer " + accessToken)
                    .header("accept", "application/json")
                    .retrieve()
                    .bodyToMono(MovieDetails.class)
                    .block();
        } catch (WebClientResponseException ex) {
            log.error("Failed to fetch movie details for id: {}. Status code: {}", id, ex.getStatusCode());
            log.error("Error message: {}", ex.getResponseBodyAsString());
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
