package com.example.reactiveWithMapper.repository;

import com.example.reactiveWithMapper.entity.PersonEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends R2dbcRepository<PersonEntity,Long> {
}
