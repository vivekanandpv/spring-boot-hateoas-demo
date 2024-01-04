package com.vivekanandpv.springboothateoasdemo.apis;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.vivekanandpv.springboothateoasdemo.models.Person;
import org.springframework.hateoas.LinkRelation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/persons")
public class PersonApi {

    @GetMapping
    public ResponseEntity<Person> getPerson() {

        Person person = new Person("John", "Doe");
        person.add(linkTo(methodOn(PersonApi.class).getPerson()).withSelfRel());

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable int id) {

        Person person = new Person("John", "Doe");
        person.add(linkTo(methodOn(PersonApi.class).getPerson()).withRel(LinkRelation.of("getAll")));
        person.add(linkTo(methodOn(PersonApi.class).getPersonById(id)).withSelfRel());

        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}
