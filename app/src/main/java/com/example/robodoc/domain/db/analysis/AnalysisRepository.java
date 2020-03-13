package com.example.robodoc.domain.db.analysis;

import android.content.Context;

import com.example.robodoc.domain.db.Database;
import com.example.robodoc.models.Analysis;

import java.util.List;

public class AnalysisRepository {

    private AnalysisDao dao;
    private Context context;


    public AnalysisRepository(Context context) {
        this.context = context;
        this.dao = Database.getInstance(context).getAnalysisDao();
    }


    public long insert(Analysis analysis) {
        return dao.insert(analysis);
    }

    public void update(Analysis analysis) {
        dao.update(analysis);
    }

    public void delete(Analysis analysis) {
        dao.delete(analysis);
    }

    public void deleteById(long id) {
        dao.deleteById(id);
    }

    public List<Analysis> getAll() {
        return dao.getAllAnalysis();
    }

    public Analysis getById(long id) {
        return dao.getById(id);
    }


    public void insertAll(Analysis... analyses) {
        dao.insertAll(analyses);
    }
}
