package com.film.repository;

import com.film.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 */
@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {

    Users getUserByUsername(String username);

    Users getUserById(int id);
}
