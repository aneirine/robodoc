package com.example.robodoc.models;

import com.example.robodoc.models.enums.Gender;

import java.util.ArrayList;
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

    public Patient(String name, Gender gender, List<Analysis> analyses){
        this.name = name;
        this.gender = gender;
        this.analyses = new ArrayList<>(analyses);
    }

}
