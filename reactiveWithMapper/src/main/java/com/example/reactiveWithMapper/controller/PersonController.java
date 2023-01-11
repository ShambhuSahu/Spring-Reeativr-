package com.example.reactiveWithMapper.controller;

import com.example.reactiveWithMapper.model.PersonRequest;
import com.example.reactiveWithMapper.model.PersonResponse;
import com.example.reactiveWithMapper.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PersonController {

    private final PersonService personService;

 @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(path ="/persons")
    public Mono<PersonResponse> addPerson(@RequestBody Mono<PersonRequest> personRequest)
    {
       return this.personService.addperson1(personRequest);
    }

    @GetMapping(path = "/persons/{id}")
    public Mono<PersonRequest> getByPersonId(@PathVariable Long id)
    {
        return this.personService.getByPersonId(id);
    }

    @GetMapping(path = "/persons")
    public Flux<PersonRequest> getAllPerson()
    {
        return this.personService.getAllPerson();
    }

    @PutMapping(path = "/persons/{id}")
    public Mono<PersonRequest> updatePerson(@PathVariable Long id,@RequestBody Mono<PersonRequest> personRequestMono)
    {
     return this.personService.updatePerson(id,personRequestMono);
    }

    @DeleteMapping(path = "/persons/{id}")
    public Mono<Void> deletePerson(@PathVariable Long id)
    {
      return this.personService.deletePerson(id);
    }

}
