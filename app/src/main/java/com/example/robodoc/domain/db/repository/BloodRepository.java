package com.example.robodoc.domain.db.repository;

import com.example.robodoc.domain.db.dao.BloodDao;
import com.example.robodoc.models.Blood;

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

    public BloodRepository(BloodDao dao) {
        this.dao = dao;
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

    /*
    *
    *   public HistoryDocsRepository(DocumentDao dao) {
        this.dao = dao;
    }

    public long insert(Document document) {
        return dao.insert(document);
    }

    public void update(Document document) {
         dao.update(document);
    }

    public void delete(Document document) {
        dao.delete(document);
    }

    public void deleteByPath(String path) {
        dao.deleteDocumentByPath(path);
    }

    public List<Document> getAll() {
        return dao.getAll();
    }

    public Document getById(long id) {
        return dao.getById(id);
    }*/


}
