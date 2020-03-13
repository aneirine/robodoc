package com.example.robodoc.models;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.robodoc.models.enums.Nominal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(tableName = "analysis")
public class Analysis {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String name;
    private Nominal nominal;
    private double value;

}
