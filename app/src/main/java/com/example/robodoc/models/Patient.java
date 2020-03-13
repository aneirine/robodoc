package com.example.robodoc.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

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
@Entity(tableName = "patients")
public class Patient {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String name;
    private String surname;
    private int age;
    private Gender gender;
    private List<Analysis> analyses;

    public Patient(String name, String surname, int age,
                   Gender gender, List<Analysis> analyses) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.analyses = analyses;
    }
}
