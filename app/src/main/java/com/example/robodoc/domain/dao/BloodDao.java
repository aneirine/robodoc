package com.example.robodoc.domain.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.robodoc.models.Blood;

import java.util.List;

@Dao
public interface BloodDao {

    @Insert
    void insertAll(Blood... bloods);

    @Insert
    void insert(Blood blood);

    @Delete
    void delete(Blood blood);

    @Query("SELECT * FROM blood")
    List<Blood> getAllBlood();

    @Query("SELECT * FROM Blood WHERE id = :id ")
    Blood getById(long id);

    @Query("DELETE FROM Blood  WHERE id = :id")
    void deleteById(long id);

}
