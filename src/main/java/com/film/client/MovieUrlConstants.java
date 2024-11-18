package com.film.client;

public enum MovieUrlConstants {
    GET_TOP_TRENDING_MOVIES("/trending/movie/week"),
    GET_MOVIE_BY_ID("/movie/{id}");

    private final String endpoint;

    MovieUrlConstants(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
