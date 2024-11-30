package com.film.entity.enums;

public enum Roles {

    USER("USER"),
    ADMIN("ADMIN");

    private final String role;

    Roles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
