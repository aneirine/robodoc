package com.example.robodoc.domain.db.symptoms;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.robodoc.models.Symptom;
import com.example.robodoc.models.enums.Nominal;
import com.example.robodoc.models.enums.Range;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface SymptomDao {

    @Insert
    void insertAll(Symptom... symptoms);

    @Insert
    long insert(Symptom symptom);

    @Update
    void update(Symptom symptom);

    @Delete
    void delete(Symptom symptom);

    @Query("SELECT * From symptoms")
    List<Symptom> getAllSymptoms();

    @Query("SELECT * FROM symptoms WHERE id = :id ")
    Symptom getById(long id);

    @Query("DELETE FROM symptoms  WHERE id = :id")
    void deleteById(long id);


    @Query("SELECT * From symptoms WHERE nominal = :nominal AND range = :range")
    Symptom findSymptomByNominalAndRange(Nominal nominal, Range range);
}
