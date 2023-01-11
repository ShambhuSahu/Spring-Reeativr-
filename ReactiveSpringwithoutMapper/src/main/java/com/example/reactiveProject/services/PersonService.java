package com.example.reactiveProject.services;

import com.example.reactiveProject.entity.PersonEntity;
import com.example.reactiveProject.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Mono<PersonEntity> addPerson1(PersonEntity personEntity)
    {
        return personRepository.save(personEntity);

    }

    public Flux<PersonEntity> getAllPerson1() {

        return personRepository.findAll();
    }

    public Mono<PersonEntity> getPersonId1(Integer id) {

        return personRepository.findById(id);
    }


    public Mono<Void> deleteperson1(Integer id) {

        return personRepository.deleteById(id);
    }
}
