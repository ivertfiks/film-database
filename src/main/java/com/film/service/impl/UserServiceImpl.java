package com.film.service.impl;

import com.film.entity.Users;
import com.film.repository.UserRepository;
import com.film.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Users createUser(String username, String email, String password) {
        Users user = userRepository.getUserByUsername(username);
        if (user != null) {
            return user;
        }
        user = new Users(username, email, password);
        return userRepository.save(user);
    }

    @Override
    public Users getUser(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public Users getUser(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public List<Users> getAllUsers() {
        return List.of();
    }
}
