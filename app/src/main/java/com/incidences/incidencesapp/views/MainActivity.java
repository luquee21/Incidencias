package com.incidences.incidencesapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.incidences.incidencesapp.R;
import com.incidences.incidencesapp.interfaces.IMainInterface;
import com.incidences.incidencesapp.presenters.MainPresenter;

public class MainActivity extends AppCompatActivity implements IMainInterface.View {
    private IMainInterface.Presenter mainPresenter;
    private final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Dentro de oncreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar t = findViewById(R.id.maintoolbar);
        t.setTitle("Listado de incidencias");
        mainPresenter = new MainPresenter(this);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> mainPresenter.onClickFloatingButton());

    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "Dentro de onrestart");
        super.onRestart();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "Dentro de onstop");
        super.onStop();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "Dentro de onresume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "Dentro de onpause");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "Dentro de ondestroy");
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "Dentro de onstart");
        super.onStart();
    }

    @Override
    public void startFormActivity() {
        Log.d(TAG, "Dentro de la función para pasar a la actividad formulario");
        Intent i = new Intent(getApplicationContext(), FormActivity.class);
        startActivity(i);
    }
}