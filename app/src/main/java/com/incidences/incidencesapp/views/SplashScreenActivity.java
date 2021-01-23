package com.incidences.incidencesapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.incidences.incidencesapp.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreenActivity extends AppCompatActivity {
    private final String TAG = "SplashScreen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Inside oncreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
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