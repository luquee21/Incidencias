package com.incidences.incidencesapp.views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.incidences.incidencesapp.R;


public class FormActivity extends AppCompatActivity {
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Toolbar t = findViewById(R.id.toolbar);
        t.setTitle("Formulario");

    }

}