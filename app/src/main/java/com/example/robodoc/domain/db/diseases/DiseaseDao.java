package com.example.robodoc.domain.db.diseases;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.robodoc.models.Disease;

import java.util.List;

@Dao
public interface DiseaseDao {

    @Insert
    void insertAll(Disease... diseases);

    @Insert
    long insert(Disease disease);

    @Update
    void update(Disease disease);

    @Delete
    void delete(Disease disease);

    @Query("SELECT * FROM diseases")
    List<Disease> getAllDiseases();

    @Query("SELECT * FROM diseases WHERE id = :id ")
    Disease getById(long id);

    @Query("DELETE FROM diseases WHERE id = :id")
    void deleteById(long id);

}
