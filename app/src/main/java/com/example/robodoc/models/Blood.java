package com.example.robodoc.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.robodoc.models.enums.Gender;
import com.example.robodoc.models.enums.Nominal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(tableName = "blood")
public class Blood {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String name;
    private double min;
    private double max;
    private Gender gender;
    private Nominal nominal;


    public Blood(String name, double min, double max, Gender gender, Nominal nominal) {
        this.name = name;
        this.min = min;
        this.max = max;
        this.gender = gender;
        this.nominal = nominal;
    }



}
