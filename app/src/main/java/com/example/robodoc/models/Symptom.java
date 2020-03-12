package com.example.robodoc.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.robodoc.models.enums.Nominal;
import com.example.robodoc.models.enums.Range;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(tableName = "symptoms")
public class Symptom {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String name;
    private Range range;
    protected Nominal nominal;

    public Symptom(String name, Range range, Nominal nominal) {
        this.name = name;
        this.range = range;
        this.nominal = nominal;
    }


}
