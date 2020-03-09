package com.example.robodoc.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    private String name;
    private String surname;
    private int age;
    private Gender gender;
    private List<Analysis> analyses;

}
