package com.example.robodoc.domain.db.diseases;

import android.content.Context;

import com.example.robodoc.domain.db.Database;
import com.example.robodoc.domain.db.symptoms.SymptomDao;
import com.example.robodoc.models.Disease;
import com.example.robodoc.models.Symptom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.robodoc.models.enums.Nominal.HB;
import static com.example.robodoc.models.enums.Nominal.RBC;
import static com.example.robodoc.models.enums.Range.UPPER;

public class DiseaseRepository {

    private DiseaseDao dao;
    private Context context;


    //Symptom dao

    public DiseaseRepository(Context context) {
        this.context = context;
        this.dao = Database.getInstance(context).getDiseaseDao();
    }

    public void initDiseaseObject() {
        SymptomDao symptomDao = Database.getInstance(context).getSymptomDao();

        Disease[] diseases = {
                new Disease("Dehydration", (ArrayList<Symptom>)
                        Arrays.asList(symptomDao.findSymptomByNominalAndRange(HB, UPPER))
                ),
                new Disease("Blood clotting", (ArrayList<Symptom>)
                        Arrays.asList(
                                symptomDao.findSymptomByNominalAndRange(HB, UPPER),
                                symptomDao.findSymptomByNominalAndRange(RBC, UPPER)
                        ))
        };

        dao.insertAll(diseases);
    }

    public long insert(Disease disease) {
        return dao.insert(disease);
    }

    public void update(Disease disease) {
        dao.update(disease);
    }

    public void delete(Disease disease) {
        dao.delete(disease);
    }

    public void deleteById(long id) {
        dao.deleteById(id);
    }

    public List<Disease> getAll() {
        return dao.getAllDiseases();
    }

    public Disease getById(long id) {
        return dao.getById(id);
    }


}
