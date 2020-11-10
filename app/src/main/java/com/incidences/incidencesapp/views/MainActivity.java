package com.incidences.incidencesapp.views;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.incidences.incidencesapp.R;
import com.incidences.incidencesapp.interfaces.IMainInterface;
import com.incidences.incidencesapp.presenters.MainPresenter;

public class MainActivity extends AppCompatActivity implements IMainInterface.View {
    private IMainInterface.Presenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar t = findViewById(R.id.maintoolbar);
        t.setTitle("Listado de incidencias");
        mainPresenter = new MainPresenter(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> mainPresenter.onClickFloatingButton());

    }

    @Override
    public void startFormActivity() {
        Intent i = new Intent(getApplicationContext(), FormActivity.class);
        startActivity(i);
    }
}