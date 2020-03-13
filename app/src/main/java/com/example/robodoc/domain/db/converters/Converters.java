package com.example.robodoc.domain.db.converters;

import androidx.room.TypeConverter;

import com.example.robodoc.models.Analysis;
import com.example.robodoc.models.Symptom;
import com.example.robodoc.models.enums.Gender;
import com.example.robodoc.models.enums.Nominal;
import com.example.robodoc.models.enums.Range;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Converters {

    @TypeConverter
    public static Gender genderFromString(String value) {
        return value != null ? Gender.valueOf(value) : null;
    }

    @TypeConverter
    public static String genderToString(Gender gender) {
        return gender.name();
    }

    @TypeConverter
    public static Nominal nominalFromString(String value) {
        return value != null ? Nominal.valueOf(value) : null;
    }

    @TypeConverter
    public static String nominalToString(Nominal nominal) {
        return nominal.name();
    }

    @TypeConverter
    public static String rangeToString(Range range) {
        return range.name();
    }

    @TypeConverter
    public static Range rangeFromString(String value) {
        return value != null ? Range.valueOf(value) : null;
    }

    @TypeConverter
    public static String stringFromSymptomList(ArrayList<Symptom> symptoms) {
        return new Gson().toJson(symptoms);
    }

    @TypeConverter
    public static ArrayList<Symptom> symptomListFormString(String value) {
        Type listType = new TypeToken<ArrayList<Symptom>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }


    @TypeConverter
    public static String stringFromAnalysisList(ArrayList<Analysis> analyses) {
        return new Gson().toJson(analyses);
    }

    @TypeConverter
    public static ArrayList<Analysis> analysisListFormString(String value) {
        Type listType = new TypeToken<ArrayList<Analysis>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }


}
