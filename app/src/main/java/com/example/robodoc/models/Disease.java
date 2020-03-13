package com.example.robodoc.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

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
@Entity(tableName = "diseases")
public class Disease {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String name;
    private ArrayList<Symptom> symptoms;

    public Disease(String name, ArrayList<Symptom> symptoms) {
        this.name = name;
        this.symptoms = symptoms;
    }
}
