package com.example.robodoc.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Analysis {

    private String name;
    private Nominal nominal;
    private double value;


}
