package com.example.robodoc.activities;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.robodoc.R;
import com.example.robodoc.domain.blood_test.BloodTestPresenter;
import com.example.robodoc.domain.blood_test.BloodTestView;
import com.example.robodoc.models.enums.Gender;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.example.robodoc.models.enums.Gender.FEMALE;
import static com.example.robodoc.models.enums.Gender.MALE;

public class BloodTestActivity extends AppCompatActivity implements BloodTestView, View.OnClickListener {

    private EditText nameEditText, hbEditText, rbcEditText;
    private Set<EditText> editTextSet;
    private Button confirmButton;
    private ImageButton maleImageButton, femaleImageButton;
    private BloodTestPresenter presenter;
    private TextView genderTextView, resultTextView;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_test);
        presenter = new BloodTestPresenter(this, this);

        nameEditText = findViewById(R.id.name_edit_text);
        hbEditText = findViewById(R.id.hb_edit_text);
        rbcEditText = findViewById(R.id.rbc_edit_text);
        confirmButton = findViewById(R.id.confirm_button);
        maleImageButton = findViewById(R.id.male_gender_image_button);
        femaleImageButton = findViewById(R.id.female_gender_image_button);
        genderTextView = findViewById(R.id.gender_text_view);
        resultTextView = findViewById(R.id.resultTextView);

        confirmButton.setOnClickListener(this);
        maleImageButton.setOnClickListener(this);
        femaleImageButton.setOnClickListener(this);

        editTextSet = new HashSet<>(Arrays.asList(hbEditText, rbcEditText));
    }

    private void confirm() {
        if (presenter.getGender() == null) {
            Toast.makeText(this, R.string.choose_gender, Toast.LENGTH_SHORT).show();
        } else {
            presenter.createAnalysis(nameEditText, editTextSet);
            //createAnalysis();
        }
    }


    /*@RequiresApi(api = Build.VERSION_CODES.N)
    private void createSymptoms(Set<Analysis> analyses) {
        List<Symptom> symptoms = new ArrayList<>();
        analyses.forEach(temp -> {
            Blood blood = presenter.getBloodList()
                    .stream().filter(
                            o -> o.getNominal() == temp.getNominal()
                                    && o.getGender() == presenter.getGender()
                    ).findFirst().get();
            if (blood.getMax() < temp.getValue()) {
                symptoms.add(presenter.getSymptomByNominalAndRange(blood.getNominal(), UPPER));
            } else if (blood.getMin() > temp.getValue()) {
                symptoms.add(presenter.getSymptomByNominalAndRange(blood.getNominal(), LOWER));
            }
        });

        defineDisease(symptoms);

    }*/


   /* private void defineDisease(List<Symptom> symptoms) {

        List<Disease> diseases = presenter.findDiseaseBySymptoms(symptoms);
        String str = "";
        for (Disease temp : diseases) {
            str += temp.getName();
        }

        resultTextView.setText(str);

    }*/


  /*  private void createAnalysis() {
        UtilMethods utilMethods = new UtilMethods();
        Set<Analysis> analyses = new HashSet<>();
        editTextSet.forEach(temp -> {
            if (!temp.getText().toString().isEmpty()) {
                String hint = temp.getHint().toString();
                Nominal nominal = Nominal.valueOf(utilMethods.createNominal(hint));
                Blood blood = presenter.getBloodList().stream().filter(
                        o -> o.getNominal() == nominal && o.getGender() == presenter.getGender()
                ).findFirst().get();

                analyses.add(new Analysis(
                        blood.getName(), nominal, Double.valueOf(temp.getText().toString())
                ));

            }

        });

        for (Analysis temp : analyses) {
            Toast.makeText(this, "" + temp.getName() + " " + temp.getValue() + " " + temp.getNominal(), Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(this, "" + analyses.size() + " " + presenter.getGender(), Toast.LENGTH_SHORT).show();

        createSymptoms(analyses);
    }
*/

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.male_gender_image_button:
                presenter.changeGender(MALE);
                break;
            case R.id.female_gender_image_button:
                presenter.changeGender(FEMALE);
                break;
            case R.id.confirm_button:
                confirm();
                break;
            default:
                break;
        }
    }

    @Override
    public void changeGender(Gender gender) {
        String genderStr = presenter.getGender() == MALE ? "male " : "female";
        String text = getString(R.string.choose_gender) + ": " + genderStr;
        genderTextView.setText(text);
    }
}
