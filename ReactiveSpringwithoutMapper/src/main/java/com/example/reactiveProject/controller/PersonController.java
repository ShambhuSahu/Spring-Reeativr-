package com.example.reactiveProject.controller;

import com.example.reactiveProject.entity.PersonEntity;
import com.example.reactiveProject.model.PersonRequest;
import com.example.reactiveProject.services.PersonService;
import io.r2dbc.spi.Parameter;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PersonController {


    private final PersonService personService;


    public PersonController(PersonService personService) {
        this.personService = personService;
    }

     @PostMapping("/persons")
    public Mono<PersonEntity> addPerson(@RequestBody PersonEntity personEntity)
     {
          return personService.addPerson1(personEntity);
     }

     @GetMapping("/persons")
    public Flux<PersonEntity> getAllPerson()
     {
         return personService.getAllPerson1();
     }

     @GetMapping("/persons/{id}")
    public Mono<PersonEntity> getPersonId(@PathVariable Integer id )
     {
         return personService.getPersonId1(id);
     }



    @DeleteMapping("/persons/{id}")
    public Mono<Void> deletePerson(@PathVariable Integer id)
    {
       return personService.deleteperson1(id);
    }

}
