package com.example.robodoc.domain.db.patient;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.robodoc.models.Patient;

import java.util.List;

@Dao
public interface PatientDao {

    @Insert
    void insertAll(Patient... patients);

    @Insert
    long insert(Patient patient);

    @Update
    void update(Patient patient);

    @Delete
    void delete(Patient patient);

    @Query("SELECT * FROM patients")
    List<Patient> getAllPatient();

    @Query("SELECT * FROM patients WHERE id = :id ")
    Patient getById(long id);

    @Query("DELETE FROM patients  WHERE id = :id")
    void deleteById(long id);


}
