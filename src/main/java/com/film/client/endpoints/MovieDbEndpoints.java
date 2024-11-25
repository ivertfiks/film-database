package com.film.client.endpoints;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieDbEndpoints {

    public static final String GET_TOP_TRENDING_MOVIES = "/trending/movie/day";
    public static final String GET_MOVIE_DETAILS_BY_ID = "/movie/{id}";
    public static final String GET_MOVIE_CREDITS_BY_ID = "/movie/{id}/credits";

    public static final String GET_CREDIT_BY_ID = "/person/{id}";
}
