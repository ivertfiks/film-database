package com.film.entity;

import com.film.entity.enums.Roles;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;
    private String password;
    private String email;
    private Roles role;

    @ElementCollection
    private List<User> subscribers;
    @ElementCollection
    private List<User> subscriptions;

    @OneToMany(mappedBy = "user")
    private List<UserFilmStatus> filmStatus;
}
