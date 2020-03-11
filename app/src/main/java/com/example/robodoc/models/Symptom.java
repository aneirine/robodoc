package com.example.robodoc.models;

import com.example.robodoc.models.enums.Nominal;
import com.example.robodoc.models.enums.Range;

public class Symptom {

    private String name;
    private Range range;
    protected Nominal nominal;

    public Symptom(String name, Range range, Nominal nominal) {
        this.name = name;
        this.range = range;
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }

    public Nominal getNominal() {
        return nominal;
    }

    public void setNominal(Nominal nominal) {
        this.nominal = nominal;
    }
}
