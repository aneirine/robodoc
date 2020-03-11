package com.example.robodoc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.robodoc.domain.menu_module.MenuPresenter;
import com.example.robodoc.domain.menu_module.MenuView;

import com.example.robodoc.domain.blood_test.*;
import com.example.robodoc.domain.training.*;



public class MainActivity extends AppCompatActivity implements MenuView, View.OnClickListener {

    private MenuPresenter menuPresenter;
    private Button bloodTestButton, trainingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        menuPresenter = new MenuPresenter(this);
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
