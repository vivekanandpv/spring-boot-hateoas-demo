package com.vivekanandpv.springboothateoasdemo.models;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Person extends RepresentationModel<Person> {

    private final String firstName;
    private final String lastName;

    public Person(
            String firstName,
            String lastName
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
