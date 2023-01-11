package com.example.reactiveProject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PersonRequest {

    private Long Id;
    private String firstName;
    private String lastName;
    private String dob;

}
