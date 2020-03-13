package com.example.robodoc.domain.blood_test;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.robodoc.domain.db.blood.BloodRepository;
import com.example.robodoc.models.Analysis;
import com.example.robodoc.models.Blood;
import com.example.robodoc.models.Disease;
import com.example.robodoc.models.enums.Gender;
import com.example.robodoc.models.enums.Nominal;
import com.example.robodoc.models.Patient;
import com.example.robodoc.models.enums.Range;
import com.example.robodoc.models.Symptom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BloodTestPresenter {

    private BloodRepository repository;
    private Gender gender;
    private BloodTestView bloodTestView;
    private Patient patient;

    public BloodTestPresenter(Gender gender, Patient patient,
                              BloodTestView bloodTestView, Context context) {
        this.gender = gender;
        this.patient = patient;
        this.bloodTestView = bloodTestView;
        repository = new BloodRepository(context);
    }

    public BloodTestPresenter(BloodTestView bloodTestView) {
        this.bloodTestView = bloodTestView;
    }

    public BloodTestPresenter(BloodTestView bloodTestView, Context context) {
        this.bloodTestView = bloodTestView;
        repository = new BloodRepository(context);
    }

    public void changeGender(Gender gender) {
        this.setGender(gender);
        bloodTestView.changeGender(gender);
    }

    public void constructPatient(List<Analysis> analyses, String name) {
        this.patient = new Patient();
    }

    public void createAnalysis(){}

 /*   @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Disease> findDiseaseBySymptoms(List<Symptom> symptoms) {
        List<Disease> diseases = new ArrayList<>();
        for (Disease temp : this.diseaseSet) {
            if (symptoms.containsAll(temp.getSymptoms())) {
                diseases.add(temp);
            }
        }

        return diseases;
    }*/
}
