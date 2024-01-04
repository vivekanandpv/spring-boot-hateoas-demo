package com.vivekanandpv.springboothateoasdemo.apis;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.vivekanandpv.springboothateoasdemo.models.Person;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class GreetingApi {
    private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping("/greeting")
    public HttpEntity<Person> greeting(
            @RequestParam(value = "name", defaultValue = "World") String name) {

        Person greeting = new Person(String.format(TEMPLATE, name));
        greeting.add(linkTo(methodOn(GreetingApi.class).greeting(name)).withSelfRel());

        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}
