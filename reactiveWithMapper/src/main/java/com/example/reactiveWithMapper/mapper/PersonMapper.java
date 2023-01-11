package com.example.reactiveWithMapper.mapper;

import com.example.reactiveWithMapper.entity.PersonEntity;
import com.example.reactiveWithMapper.model.PersonRequest;

import com.example.reactiveWithMapper.model.PersonResponse;
import org.mapstruct.Mapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import reactor.core.publisher.Flux;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonEntity modelToentity(PersonRequest personRequest);
    PersonRequest entityTomodel (PersonEntity personEntity);
    PersonResponse entityToModel2(PersonEntity personEntity);


}
