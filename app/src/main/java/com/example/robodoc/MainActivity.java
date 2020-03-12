package com.example.robodoc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.robodoc.domain.blood_test.BloodTestActivity;
import com.example.robodoc.domain.db.Database;
import com.example.robodoc.domain.menu_module.MenuPresenter;
import com.example.robodoc.domain.menu_module.MenuView;
import com.example.robodoc.domain.training.TrainingActivity;
import com.example.robodoc.models.Blood;

import java.util.List;


public class MainActivity extends AppCompatActivity implements MenuView, View.OnClickListener {

    private MenuPresenter menuPresenter;
    private Button bloodTestButton, trainingButton;
    private SharedPreferences prefs = null;


    @Override
    protected void onResume() {
        super.onResume();
        if (prefs.getBoolean("firstrun", true)) {
            Database.getInstance(getBaseContext());
            menuPresenter.initDatabase();
            List<Blood> blood = menuPresenter.getBlood();
            String text = "";
            for (Blood temp : blood) {
                text += temp.getName() + " " + temp.getNominal().name();
            }
            Toast.makeText(this, "" + text, Toast.LENGTH_SHORT).show();
            prefs.edit().putBoolean("firstrun", false).commit();

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = getSharedPreferences("com.mycompany.myAppName", MODE_PRIVATE);
        menuPresenter = new MenuPresenter(this, this);


        initComponents();

    }

    private void initComponents() {
        bloodTestButton = findViewById(R.id.button_blood_test);
        trainingButton = findViewById(R.id.button_training);

        bloodTestButton.setOnClickListener(this);
        trainingButton.setOnClickListener(this);
    }


    @Override
    public void transferActivity(Class transferClass) {
        Intent intent = new Intent(MainActivity.this, transferClass);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_blood_test:
                menuPresenter.transferActivity(BloodTestActivity.class);
                break;
            case R.id.button_training:
                menuPresenter.transferActivity(TrainingActivity.class);
                break;
            default:
                break;
        }
    }
}
