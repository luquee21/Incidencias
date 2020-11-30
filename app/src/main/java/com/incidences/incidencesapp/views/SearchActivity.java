package com.incidences.incidencesapp.views;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.incidences.incidencesapp.R;
import com.incidences.incidencesapp.interfaces.ISearchInterface;
import com.incidences.incidencesapp.presenters.SearchPresenter;

import java.util.Calendar;
import java.util.Objects;

public class SearchActivity extends AppCompatActivity implements ISearchInterface.View {
    private static final String TAG = "SearchActivity";
    public final Calendar c = Calendar.getInstance();
    final int month = c.get(Calendar.MONTH);
    final int day = c.get(Calendar.DAY_OF_MONTH);
    final int year = c.get(Calendar.YEAR);
    private final String bar = "/";
    private final String zero = "0";
    private ISearchInterface.Presenter presenter;
    private Button search;
    private EditText date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Inside oncreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        search = findViewById(R.id.buttonsearch);
        date = findViewById(R.id.date);
        presenter = new SearchPresenter(this);
        Toolbar t = findViewById(R.id.toolbarsearch);
        setSupportActionBar(t);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Buscar");
        date.setOnClickListener(v -> {
            presenter.onClickDate();
        });
        search.setOnClickListener(v -> {
            presenter.onClickSearch();
        });
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "Back button pressed");
        finish();
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.helpsearch:
                break;
            case android.R.id.home:
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
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
    public void finishSearchActivity() {
        finish();
    }

    @Override
    public void showDate() {
        DatePickerDialog datePicker = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            final int actualMonth = month + 1;
            String dayFormated = (dayOfMonth < 10) ? zero + dayOfMonth : String.valueOf(dayOfMonth);
            String monthFormated = (actualMonth < 10) ? zero + actualMonth : String.valueOf(actualMonth);
            date.setText(dayFormated + bar + monthFormated + bar + year);
        }, year, month, day);
        datePicker.show();
    }


}