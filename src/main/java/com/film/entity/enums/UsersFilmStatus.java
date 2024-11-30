package com.film.entity.enums;

public enum UsersFilmStatus {

    PLANNED("PLANNED"),
    WATCHING("WATCHING"),
    WATCHED("WATCHED"),
    SKIPPED("SKIPPED"),
    ABANDONED("ABANDONED");

    private final String status;

    UsersFilmStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
