package com.example.robodoc.domain.blood_test;

import android.os.Build;

import androidx.annotation.RequiresApi;

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

    private Gender gender;
    private BloodTestView bloodTestView;
    private Patient patient;
    private Set<Blood> bloodList;
    private Set<Symptom> symptoms;
    private Set<Disease> diseaseSet;

    public BloodTestPresenter(Gender gender, Patient patient, BloodTestView bloodTestView) {
        this.gender = gender;
        this.patient = patient;
        this.bloodTestView = bloodTestView;
        bloodList = new HashSet<>();
        diseaseSet = new HashSet<>();
        symptoms = new HashSet<>();
    }

    public BloodTestPresenter(BloodTestView bloodTestView) {
        this.bloodTestView = bloodTestView;
    }

    public void changeGender(Gender gender) {
        this.setGender(gender);
        bloodTestView.changeGender(gender);
    }

    public void constructPatient(List<Analysis> analyses, String name) {
        this.patient = new Patient(name, this.getGender(), analyses);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Symptom getSymptomByNominalAndRange(Nominal nominal, Range range) {

        return symptoms.stream().filter(
                o -> o.getNominal() == nominal && o.getRange() == range
        ).findFirst().get();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Disease> findDiseaseBySymptoms(List<Symptom> symptoms) {
        List<Disease> diseases = new ArrayList<>();
        for (Disease temp : this.diseaseSet) {
            if (symptoms.containsAll(temp.getSymptoms())) {
                diseases.add(temp);
            }
        }

        return diseases;
    }
}
