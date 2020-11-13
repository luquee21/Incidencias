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
        Log.d(TAG, "Dentro de oncreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        formPresenter = new FormPresenter(this);
        save = findViewById(R.id.save);
        save.setOnClickListener(v -> {
            Log.d(TAG, "Boton guardado click");
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
                Log.d(TAG, "Pulsado botón up");
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "Pulsado botón atras");
        finish();
        super.onBackPressed();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    public void finishFormActivity() {
        finish();
    }
}