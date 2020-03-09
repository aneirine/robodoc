package com.example.robodoc.models;

public class Blood {

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
