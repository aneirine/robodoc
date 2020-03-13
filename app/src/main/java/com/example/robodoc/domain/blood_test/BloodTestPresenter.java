package com.example.robodoc.domain.blood_test;

import android.content.Context;
import android.widget.EditText;

import com.example.robodoc.domain.db.analysis.AnalysisRepository;
import com.example.robodoc.domain.db.blood.BloodRepository;
import com.example.robodoc.domain.db.patient.PatientRepository;
import com.example.robodoc.models.Analysis;
import com.example.robodoc.models.Blood;
import com.example.robodoc.models.Patient;
import com.example.robodoc.models.enums.Gender;
import com.example.robodoc.models.enums.Nominal;
import com.example.robodoc.utils.UtilMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

    private BloodRepository bloodRepository;
    private AnalysisRepository analysisRepository;
    private PatientRepository patientRepository;
    private Gender gender;
    private BloodTestView bloodTestView;

    public BloodTestPresenter(BloodTestView bloodTestView, Context context) {
        this.bloodTestView = bloodTestView;
        bloodRepository = new BloodRepository(context);
        analysisRepository = new AnalysisRepository(context);
        patientRepository = new PatientRepository(context);
    }

    public void changeGender(Gender gender) {
        this.setGender(gender);
        bloodTestView.changeGender(gender);
    }

    public void createPatient(List<Analysis> analyses, String name) {
        int randomInteger = new Random().nextInt();
        Patient patient = new Patient(
                name, "surname " + randomInteger, randomInteger, this.gender, (ArrayList<Analysis>) analyses
        );

        patientRepository.insert(patient);
    }

    public void createAnalysis(EditText nameEditText, Set<EditText> editTextSet) {
        List<Analysis> analyses = new ArrayList<>();
        UtilMethods utilMethods = new UtilMethods();
        for (EditText temp : editTextSet) {
            if (temp.getText() != null) {
                String hint = temp.getHint().toString();
                Nominal nominal = Nominal.valueOf(utilMethods.createNominal(hint));
                Blood blood = bloodRepository.findByNominalAndGender(nominal, this.gender);
                Analysis analysis = new Analysis(
                        blood.getName(), nominal, Double.valueOf(temp.getText().toString())
                );
                analyses.add(analysis);
            }
        }
        analysisRepository.insertAll(analyses.toArray(new Analysis[analyses.size()]));
        createPatient(analyses, nameEditText.getText().toString());
    }

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
