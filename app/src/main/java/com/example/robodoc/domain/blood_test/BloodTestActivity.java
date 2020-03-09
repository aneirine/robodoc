package com.example.robodoc.domain.blood_test;

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
import com.example.robodoc.models.Analysis;
import com.example.robodoc.models.Blood;
import com.example.robodoc.models.Disease;
import com.example.robodoc.models.Gender;
import com.example.robodoc.models.Nominal;
import com.example.robodoc.models.Range;
import com.example.robodoc.models.Symptom;
import com.example.robodoc.utils.UtilMethods;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.example.robodoc.models.Gender.FEMALE;
import static com.example.robodoc.models.Gender.MALE;
import static com.example.robodoc.models.Nominal.HB;
import static com.example.robodoc.models.Nominal.RBC;
import static com.example.robodoc.models.Range.LOWER;
import static com.example.robodoc.models.Range.UPPER;
import static com.example.robodoc.utils.Constants.HB_FEMALE_MAX;
import static com.example.robodoc.utils.Constants.HB_FEMALE_MIN;
import static com.example.robodoc.utils.Constants.HB_MALE_MAX;
import static com.example.robodoc.utils.Constants.HB_MALE_MIN;
import static com.example.robodoc.utils.Constants.RBC_FEMALE_MAX;
import static com.example.robodoc.utils.Constants.RBC_FEMALE_MIN;
import static com.example.robodoc.utils.Constants.RBC_MALE_MAX;
import static com.example.robodoc.utils.Constants.RBC_MALE_MIN;

public class BloodTestActivity extends AppCompatActivity implements BloodTestView, View.OnClickListener {


    private EditText hbEditText, rbcEditText;
    private Set<EditText> editTextSet;
    private Button confirmButton;
    private ImageButton maleImageButton, femaleImageButton;
    private BloodTestPresenter presenter;
    private TextView genderTextView;

    //переместить коллекции в презентер, написать для них методы
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_test);


        presenter = new BloodTestPresenter(this);
        initBloodObjects();
        initComponents();
        initSymptoms();
        initDiseases();

    }


    private void initBloodObjects() {
        presenter.setBloodList(
                new HashSet<>(Arrays.asList(
                        new Blood("Hemoglobin", HB_MALE_MIN, HB_MALE_MAX, MALE, HB),
                        new Blood("Hemoglobin", HB_FEMALE_MIN, HB_FEMALE_MAX, FEMALE, HB),
                        new Blood("Red blood cells", RBC_MALE_MIN, RBC_MALE_MAX, MALE, RBC),
                        new Blood("Red blood cells", RBC_FEMALE_MIN, RBC_FEMALE_MAX, FEMALE, RBC)
                ))
        );

    }

    private void initSymptoms() {
        presenter.setSymptoms(
                new HashSet<>(Arrays.asList(
                        new Symptom("Hemoglobin is " + UPPER.getName(), UPPER, HB),
                        new Symptom("Hemoglobin is " + LOWER.getName(), LOWER, HB),
                        new Symptom("Red blood cells is " + UPPER.getName(), UPPER, RBC),
                        new Symptom("Red blood cells is " + LOWER.getName(), LOWER, RBC)

                ))
        );
    }

    private void initDiseases(){
        presenter.setDiseaseSet(
                new HashSet<>(Arrays.asList(
                        new Disease()
                ))
        );
    }

    //симптомы сделать словарными, добавлять их просто по необходимоти. Они будут и в болезнях
    // и в пациенте

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initComponents() {
        hbEditText = findViewById(R.id.hb_edit_text);
        rbcEditText = findViewById(R.id.rbc_edit_text);
        confirmButton = findViewById(R.id.confirm_button);
        maleImageButton = findViewById(R.id.male_gender_image_button);
        femaleImageButton = findViewById(R.id.female_gender_image_button);
        genderTextView = findViewById(R.id.gender_text_view);

        confirmButton.setOnClickListener(view -> confirm());
        maleImageButton.setOnClickListener(this);
        femaleImageButton.setOnClickListener(this);

        editTextSet = new HashSet<>(Arrays.asList(hbEditText, rbcEditText));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void confirm() {
        if (presenter.getGender() == null) {
            Toast.makeText(this, R.string.choose_gender, Toast.LENGTH_SHORT).show();
        } else createAnalysis();
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void defineDisease(Set<Analysis> analyses) {


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void createAnalysis() {
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

        defineDisease(analyses);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.male_gender_image_button:
                presenter.changeGender(MALE);
                break;
            case R.id.female_gender_image_button:
                presenter.changeGender(FEMALE);
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
