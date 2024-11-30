package com.film.entity;

import com.film.entity.enums.Roles;
import com.film.entity.enums.UsersFilmStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class User {
    private String username;
    private String password;
    private String email;
    private Roles role;

    private List<User> subscribers;
    private List<User> subscriptions;

    private Map<Movie, UsersFilmStatus> savedMovies;

}
