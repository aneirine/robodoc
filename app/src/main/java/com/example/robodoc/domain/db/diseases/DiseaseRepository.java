package com.example.robodoc.domain.db.diseases;

import android.content.Context;

import com.example.robodoc.domain.db.Database;
import com.example.robodoc.models.Disease;

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
        /*Disease [] diseases = {
                new Disease("Dehydration",
                        Arrays.asList(
                                presenter.getSymptomByNominalAndRange(HB, UPPER)
                        )),
                new Disease("Blood clotting",
                        Arrays.asList(
                                presenter.getSymptomByNominalAndRange(HB, UPPER),
                                presenter.getSymptomByNominalAndRange(RBC, UPPER)
                        ))
                ))
        }*/
    }

 /*   public long insert(Disease disease) {
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
        return dao.getAllDisease();
    }

    public Disease getById(long id) {
        return dao.getById(id);
    }
*/

}
