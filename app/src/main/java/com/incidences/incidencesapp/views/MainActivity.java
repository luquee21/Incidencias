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
        Log.d(TAG, "Inside oncreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar t = findViewById(R.id.maintoolbar);
        t.setTitle("Listado de incidencias");
        mainPresenter = new MainPresenter(this);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> mainPresenter.onClickFloatingButton());

    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "Button back pressed");
        finish();
        super.onBackPressed();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "Inside onRestart");
        super.onRestart();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "Inside onStop");
        super.onStop();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "Inside onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "Inside onPause");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "Inside OnDestroy");
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "Inside OnStart");
        super.onStart();
    }

    @Override
    public void startFormActivity() {
        Log.d(TAG, "Inside startFormActivity to launch FormActivity");
        Intent i = new Intent(getApplicationContext(), FormActivity.class);
        startActivity(i);
    }
}