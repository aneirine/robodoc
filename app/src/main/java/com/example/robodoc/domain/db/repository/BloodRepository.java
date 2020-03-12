package com.example.robodoc.domain.db.repository;

import android.content.Context;

import com.example.robodoc.domain.db.Database;
import com.example.robodoc.domain.db.dao.BloodDao;
import com.example.robodoc.models.Blood;

import java.util.List;

import static com.example.robodoc.models.enums.Gender.FEMALE;
import static com.example.robodoc.models.enums.Gender.MALE;
import static com.example.robodoc.models.enums.Nominal.HB;
import static com.example.robodoc.models.enums.Nominal.RBC;
import static com.example.robodoc.utils.Constants.HB_FEMALE_MAX;
import static com.example.robodoc.utils.Constants.HB_FEMALE_MIN;
import static com.example.robodoc.utils.Constants.HB_MALE_MAX;
import static com.example.robodoc.utils.Constants.HB_MALE_MIN;
import static com.example.robodoc.utils.Constants.RBC_FEMALE_MAX;
import static com.example.robodoc.utils.Constants.RBC_FEMALE_MIN;
import static com.example.robodoc.utils.Constants.RBC_MALE_MAX;
import static com.example.robodoc.utils.Constants.RBC_MALE_MIN;

public class BloodRepository {
    private BloodDao dao;
    private Context context;


    public BloodRepository(Context context) {
        this.context = context;
        this.dao = Database.getInstance(context).getBloodDao();

    }

    public void initBloodObjects() {
        Blood[] blood = {
                new Blood("Hemoglobin", HB_MALE_MIN, HB_MALE_MAX, MALE, HB),
                new Blood("Hemoglobin", HB_FEMALE_MIN, HB_FEMALE_MAX, FEMALE, HB),
                new Blood("Red blood cells", RBC_MALE_MIN, RBC_MALE_MAX, MALE, RBC),
                new Blood("Red blood cells", RBC_FEMALE_MIN, RBC_FEMALE_MAX, FEMALE, RBC)
        };
        dao.insertAll(blood);
    }

    public long insert(Blood blood) {
        return dao.insert(blood);
    }

    public void update(Blood blood) {
        dao.update(blood);
    }

    public void delete(Blood blood) {
        dao.delete(blood);
    }

    public void deleteById(long id) {
        dao.deleteById(id);
    }

    public List<Blood> getAll() {
        return dao.getAllBlood();
    }

    public Blood getById(long id) {
        return dao.getById(id);
    }


}
