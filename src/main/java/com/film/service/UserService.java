package com.film.service;

import java.util.List;

import com.film.entity.Users;

public interface UserService {

    Users createUser(String username, String email, String password);
    Users getUser(int id);
    Users getUser(String username);
    List<Users> getAllUsers();

}
