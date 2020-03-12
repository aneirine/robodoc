package com.example.robodoc.domain.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.robodoc.models.Blood;

import java.util.List;

@Dao
public interface BloodDao {

    @Insert
    void insertAll(Blood... bloods);

    @Insert
    long insert(Blood blood);

    @Update
    void update(Blood blood);

    @Delete
    void delete(Blood blood);

    @Query("SELECT * FROM blood")
    List<Blood> getAllBlood();

    @Query("SELECT * FROM blood WHERE id = :id ")
    Blood getById(long id);

    @Query("DELETE FROM blood  WHERE id = :id")
    void deleteById(long id);




}
