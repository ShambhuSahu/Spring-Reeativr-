package com.example.reactiveWithMapper.service;

import com.example.reactiveWithMapper.mapper.PersonMapper;
import com.example.reactiveWithMapper.model.PersonRequest;
import com.example.reactiveWithMapper.model.PersonResponse;
import com.example.reactiveWithMapper.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Log4j2
public class PersonService {


private final PersonMapper personMapper;
private final PersonRepository personRepository;

@Autowired
    public PersonService(PersonMapper personMapper, PersonRepository personRepository) {
        this.personMapper = personMapper;
        this.personRepository = personRepository;
}

    public Mono<PersonResponse> addperson1(Mono<PersonRequest> personRequest) {
        log.info("data is created");
        return personRequest.map(personMapper::modelToentity)
            .flatMap(this.personRepository::save)
            .map(personMapper::entityToModel2);
    }
    public Mono<PersonRequest> getByPersonId(Long id) {
      return this.personRepository.findById(id).map(personMapper::entityTomodel);
    }

    public Flux<PersonRequest> getAllPerson()
    {
        return this.personRepository.findAll().map(personMapper::entityTomodel);
    }

    public Mono<PersonRequest> updatePerson(Long id, Mono<PersonRequest> personRequestMono) {

          return this.personRepository.findById(id)
                  .flatMap(u -> personRequestMono.map(personMapper::modelToentity)
                          .doOnNext(e -> e.setId(id))).flatMap(personRepository::save)
                  .map(personMapper::entityTomodel);
    }

    public Mono<Void> deletePerson(Long id) {

    return this.personRepository.deleteById(id);
    }
}
