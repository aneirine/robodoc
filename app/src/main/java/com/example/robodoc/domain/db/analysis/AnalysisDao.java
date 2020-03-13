package com.example.robodoc.domain.db.analysis;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.robodoc.models.Analysis;

import java.util.List;

@Dao
public interface AnalysisDao {

    @Insert
    void insertAll(Analysis... analysis);

    @Insert
    long insert(Analysis analysis);

    @Update
    void update(Analysis analysis);

    @Delete
    void delete(Analysis analysis);

    @Query("SELECT * FROM analysis")
    List<Analysis> getAllAnalysis();

    @Query("SELECT * FROM analysis WHERE id = :id ")
    Analysis getById(long id);

    @Query("DELETE FROM analysis  WHERE id = :id")
    void deleteById(long id);


}
