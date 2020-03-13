package com.example.robodoc.domain.db.patient;

import android.content.Context;

import com.example.robodoc.domain.db.Database;
import com.example.robodoc.models.Patient;

import java.util.List;

public class PatientRepository {


    private PatientDao dao;
    private Context context;


    public PatientRepository(Context context) {
        this.context = context;
        this.dao = Database.getInstance(context).getPatientDao();
    }

    public long insert(Patient patient) {
        return dao.insert(patient);
    }

    public void update(Patient patient) {
        dao.update(patient);
    }

    public void delete(Patient patient) {
        dao.delete(patient);
    }

    public void deleteById(long id) {
        dao.deleteById(id);
    }

    public List<Patient> getAll() {
        return dao.getAllPatient();
    }

    public Patient getById(long id) {
        return dao.getById(id);
    }


}
