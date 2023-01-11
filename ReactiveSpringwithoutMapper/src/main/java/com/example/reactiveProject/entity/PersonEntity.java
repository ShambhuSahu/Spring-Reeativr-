package com.example.reactiveProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Person")
public class PersonEntity {

    @Id
    private Integer id;
    private String firstname;
    private String lastname;

}
