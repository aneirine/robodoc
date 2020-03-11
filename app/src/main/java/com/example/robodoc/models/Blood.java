package com.example.robodoc.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.robodoc.models.enums.Gender;
import com.example.robodoc.models.enums.Nominal;

@Entity
public class Blood {

    @PrimaryKey
    private long id;

    private String name;
    private double min;
    private double max;
    private Gender gender;
    private Nominal nominal;


    public Blood() {
    }

    public Blood(String name, double min, double max, Gender gender, Nominal nominal) {
        this.name = name;
        this.min = min;
        this.max = max;
        this.gender = gender;
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Nominal getNominal() {
        return nominal;
    }

    public void setNominal(Nominal nominal) {
        this.nominal = nominal;
    }
}
