package com.incidences.incidencesapp.views;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;
import com.incidences.incidencesapp.R;
import com.incidences.incidencesapp.interfaces.IFormInterface;
import com.incidences.incidencesapp.presenters.FormPresenter;

import java.util.Calendar;
import java.util.Objects;


public class FormActivity extends AppCompatActivity implements IFormInterface.View {
    private final String TAG = "FormActivity";
    public final Calendar c = Calendar.getInstance();
    final int month = c.get(Calendar.MONTH);
    final int day = c.get(Calendar.DAY_OF_MONTH);
    final int year = c.get(Calendar.YEAR);
    private final String bar = "/";
    private final String zero = "0";
    private Button save, delete;
    private ImageView dateimage;
    private TextInputEditText dateform;
    private IFormInterface.Presenter formPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Inside onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Toolbar t = findViewById(R.id.toolbar);
        setSupportActionBar(t);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Formulario");
        formPresenter = new FormPresenter(this);
        save = findViewById(R.id.save);
        delete = findViewById(R.id.delete);
        dateform = findViewById(R.id.dateform);
        dateimage = findViewById(R.id.dateimage);
        save.setOnClickListener(v -> {
            Log.d(TAG, "Click save button pressed");
            formPresenter.onClickSaveButton();
        });
        dateimage.setOnClickListener(v -> {
            Log.d(TAG, "Click dateimagebutton pressed");
            formPresenter.onClickDateImageButton();
        });
        delete.setOnClickListener(v -> {
            Log.d(TAG, "Click delete button pressed");
            formPresenter.onClickDeleteButton();
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.form_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Log.d(TAG, "Up button pressed");
                finish();
                break;
            case R.id.helpform:
                break;

        }
        return super.onOptionsItemSelected(item);
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

    @Override
    public void showDialogDeleteForm() {
        AlertDialog.Builder builder = new AlertDialog.Builder(FormActivity.this);
        builder.setTitle(R.string.delete);
        builder.setMessage(R.string.dialog_delete_form);
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishFormActivity();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    @Override
    public void showDate() {
        DatePickerDialog datePicker = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            final int actualMonth = month + 1;
            String dayFormated = (dayOfMonth < 10) ? zero + dayOfMonth : String.valueOf(dayOfMonth);
            String monthFormated = (actualMonth < 10) ? zero + actualMonth : String.valueOf(actualMonth);
            dateform.setText(dayFormated + bar + monthFormated + bar + year);
        }, year, month, day);
        datePicker.show();
    }
}