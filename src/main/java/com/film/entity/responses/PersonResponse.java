package com.film.entity.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.film.entity.Person;
import lombok.Data;

import java.util.List;
@Data
public class PersonResponse {

    @JsonProperty("cast")
    private List<Person> persons;

}
