package com.example.robodoc.domain.db.converters;

import androidx.room.TypeConverter;

import com.example.robodoc.models.enums.Gender;
import com.example.robodoc.models.enums.Nominal;
import com.example.robodoc.models.enums.Range;

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

}
