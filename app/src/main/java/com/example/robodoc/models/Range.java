package com.example.robodoc.models;

public enum Range {

    UPPER("upper"), LOWER("lower");

    private String name;

    Range(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
