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
        Log.d(TAG, "Dentro de oncreate");
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
}