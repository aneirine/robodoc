package com.example.robodoc.domain.db.converters;

import androidx.room.TypeConverter;

import com.example.robodoc.models.enums.Gender;

public class Converters {

    @TypeConverter
    public static Gender fromString(String value) {
        return value != null ? Gender.valueOf(value) : null;
    }

    @TypeConverter
    public static String genderToString(Gender gender) {
        return gender.name();
    }


}
