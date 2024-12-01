package com.film.entity;

import com.film.entity.enums.Roles;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Users {

    public Users(String username, String email, String password) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;
    private String password;
    private String email;
    private Roles role;

    @ElementCollection
    private List<Users> subscribers;
    @ElementCollection
    private List<Users> subscriptions;

    @OneToMany(mappedBy = "users")
    private List<UserFilmStatus> filmStatus;
}
