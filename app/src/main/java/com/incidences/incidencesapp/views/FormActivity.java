package com.incidences.incidencesapp.views;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.incidences.incidencesapp.R;
import com.incidences.incidencesapp.interfaces.IFormInterface;
import com.incidences.incidencesapp.presenters.FormPresenter;


public class FormActivity extends AppCompatActivity implements IFormInterface.View {
    private final String TAG = "FormActivity";
    private Button save;
    private IFormInterface.Presenter formPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Inside onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        formPresenter = new FormPresenter(this);
        save = findViewById(R.id.save);
        save.setOnClickListener(v -> {
            Log.d(TAG, "Click save button pressed");
            formPresenter.onClickSaveButton();
        });
        Toolbar t = findViewById(R.id.toolbar);
        setSupportActionBar(t);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Formulario");

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Log.d(TAG, "Up button pressed");
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
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



    @Override
    public void finishFormActivity() {
        Log.d(TAG, "Finishing FormActivity");
        finish();
    }
}