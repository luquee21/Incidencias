package com.incidences.incidencesapp.views;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.incidences.incidencesapp.R;

import java.util.Objects;

public class AboutActivity extends AppCompatActivity {
    private final static String TAG = "AboutActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Inside oncreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar t = findViewById(R.id.toolbarabout);
        setSupportActionBar(t);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.about_me);
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "Back button pressed");
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


}