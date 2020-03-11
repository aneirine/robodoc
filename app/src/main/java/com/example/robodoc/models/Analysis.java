package com.example.robodoc.models;


import com.example.robodoc.models.enums.Nominal;

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
