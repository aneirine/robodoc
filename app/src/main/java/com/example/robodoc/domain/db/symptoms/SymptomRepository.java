package com.example.robodoc.domain.db.symptoms;

import android.content.Context;

import com.example.robodoc.domain.db.Database;
import com.example.robodoc.models.Symptom;

import java.util.List;

import static com.example.robodoc.models.enums.Nominal.HB;
import static com.example.robodoc.models.enums.Nominal.RBC;
import static com.example.robodoc.models.enums.Range.LOWER;
import static com.example.robodoc.models.enums.Range.UPPER;

public class SymptomRepository {

    private SymptomDao dao;
    private Context context;


    public SymptomRepository(Context context) {
        this.context = context;
        this.dao = Database.getInstance(context).getSymptomDao();
    }
/*

    public void initSymptomObjects() {
        Symptom[] symptoms = {
                new Symptom("Hemoglobin is " + UPPER.getName(), UPPER, HB),
                new Symptom("Hemoglobin is " + LOWER.getName(), LOWER, HB),
                new Symptom("Red blood cells is " + UPPER.getName(), UPPER, RBC),
                new Symptom("Red blood cells is " + LOWER.getName(), LOWER, RBC)
        };
        dao.insertAll(symptoms);
    }

    public long insert(Symptom symptom) {
        return dao.insert(symptom);
    }

    public void update(Symptom symptom) {
        dao.update(symptom);
    }

    public void delete(Symptom symptom) {
        dao.delete(symptom);
    }

    public void deleteById(long id) {
        dao.deleteById(id);
    }

    public List<Symptom> getAll() {
        return dao.getAllSymptoms();
    }

    public Symptom getById(long id) {
        return dao.getById(id);
    }

*/

}
