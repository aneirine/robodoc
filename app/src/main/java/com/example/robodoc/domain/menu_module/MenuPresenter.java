package com.example.robodoc.domain.menu_module;

import android.content.Context;

import com.example.robodoc.domain.db.blood.BloodRepository;
import com.example.robodoc.domain.db.diseases.DiseaseRepository;
import com.example.robodoc.domain.db.symptoms.SymptomRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuPresenter {

    private MenuView menuView;
    private BloodRepository bloodRepository;
    private SymptomRepository symptomRepository;
    private DiseaseRepository diseaseRepository;

    public MenuPresenter(MenuView menuView, Context context) {
        bloodRepository = new BloodRepository(context);
        this.menuView = menuView;
    }

    public void transferActivity(Class transferClass) {
        menuView.transferActivity(transferClass);
    }

    public void initDatabase() {
        bloodRepository.initBloodObjects();
       // symptomRepository.initSymptomObjects();
        //diseaseRepository.initDiseaseObject();
    }


}
