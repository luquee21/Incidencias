package com.incidences.incidencesapp.views;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.incidences.incidencesapp.R;
import com.incidences.incidencesapp.interfaces.IFormInterface;
import com.incidences.incidencesapp.models.IncidencesEntity;
import com.incidences.incidencesapp.presenters.FormPresenter;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;


public class FormActivity extends AppCompatActivity implements IFormInterface.View {
    public final Calendar c = Calendar.getInstance();
    final int month = c.get(Calendar.MONTH);
    final int day = c.get(Calendar.DAY_OF_MONTH);
    final int year = c.get(Calendar.YEAR);
    private final String TAG = "FormActivity";
    private final String bar = "/";
    private final String zero = "0";
    private final int CODE_WRITE_EXTERNAL_STORAGE_PERMISSION = 123;
    private final int REQUEST_SELECT_IMAGE = 201;
    private ArrayAdapter<String> adapter;
    private Button save, delete, addOptions, empty;
    private ImageView dateimage;
    private ArrayList<String> options;
    private Spinner spinner;
    private IFormInterface.Presenter formPresenter;
    private IncidencesEntity iEntity;
    private TextInputEditText nameTIET, siteTIET, dateTIET, descriptionTIET, phoneTIET;
    private TextInputLayout nameTIL, siteTIL, dateTIL, descriptionTIL, phoneTIL;
    private ImageButton photo;
    private Switch switch1;
    private String id;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Inside onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Toolbar t = findViewById(R.id.toolbar);
        setSupportActionBar(t);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.form);
        formPresenter = new FormPresenter(this, getApplicationContext());
        iEntity = new IncidencesEntity();
        spinner();
        binds();
        checkingData();
        listeners();
        checkData();
    }

    private void checkingData() {
        id = getIntent().getStringExtra("id");
        if (id != null) {
            flag = true;
            delete.setVisibility(View.VISIBLE);
            formPresenter.getItemById(id);
        }


    }


    private void spinner() {
        Log.d(TAG, "creating spinner...");
        spinner = findViewById(R.id.spinner);
        options = formPresenter.getSevereties();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        spinner.setAdapter(adapter);
    }

    private void binds() {
        Log.d(TAG, "binding...");
        switch1 = findViewById(R.id.switch1);
        empty = findViewById(R.id.empty);
        photo = findViewById(R.id.photo);
        save = findViewById(R.id.save);
        delete = findViewById(R.id.delete);
        delete.setVisibility(View.GONE);
        addOptions = findViewById(R.id.addOptions);
        dateimage = findViewById(R.id.dateimage);
        nameTIL = findViewById(R.id.nameTIL);
        nameTIET = findViewById(R.id.nameTIET);
        siteTIL = findViewById(R.id.siteTIL);
        siteTIET = findViewById(R.id.siteTIET);
        dateTIL = findViewById(R.id.dateTIL);
        dateTIET = findViewById(R.id.dateTIET);
        descriptionTIL = findViewById(R.id.descriptionTIL);
        descriptionTIET = findViewById(R.id.descriptionTIET);
        phoneTIL = findViewById(R.id.phoneTIL);
        phoneTIET = findViewById(R.id.phoneTIET);
    }

    private void checkData() {
        Log.d(TAG, "checking data...");
        nameTIET.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                Log.d(TAG, "Exit name EditText");
                String result = iEntity.setName(Objects.requireNonNull(nameTIET.getText()).toString());
                if (result.equals("")) {
                    nameTIL.setError("");
                } else {
                    nameTIL.setError(formPresenter.getError(result));
                }
            } else {
                Log.d(TAG, "Input name EditText");
            }
        });

        siteTIET.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                Log.d(TAG, "Exit site EditText");
                String result = iEntity.setSite(Objects.requireNonNull(siteTIET.getText()).toString());
                if (result.equals("")) {
                    siteTIL.setError("");
                } else {
                    siteTIL.setError(formPresenter.getError(result));
                }
            } else {
                Log.d(TAG, "Input site EditText");
            }
        });

        dateTIET.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                Log.d(TAG, "Exit date EditText");
                String result = iEntity.setDate(Objects.requireNonNull(dateTIET.getText()).toString());
                if (result.equals("")) {
                    dateTIL.setError("");
                } else {
                    dateTIL.setError(formPresenter.getError(result));
                }
            } else {
                Log.d(TAG, "Input date EditText");
            }
        });

        descriptionTIET.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                Log.d(TAG, "Exit description EditText");
                String result = iEntity.setDescription(Objects.requireNonNull(descriptionTIET.getText()).toString());
                if (result.equals("")) {
                    descriptionTIL.setError("");
                } else {
                    descriptionTIL.setError(formPresenter.getError(result));
                }
            } else {
                Log.d(TAG, "Input description EditText");
            }
        });

        phoneTIET.setOnFocusChangeListener((v, hasFocus) -> {
            if (!hasFocus) {
                Log.d(TAG, "Exit phone EditText");
                String result = iEntity.setPhone(Objects.requireNonNull(phoneTIET.getText()).toString());
                if (result.equals("")) {
                    phoneTIL.setError("");
                } else {
                    phoneTIL.setError(formPresenter.getError(result));
                }
            } else {
                Log.d(TAG, "Input phone EditText");
            }
        });
    }

    private void listeners() {
        Log.d(TAG, "checking listeners...");
        save.setOnClickListener(v -> {
            boolean flag2 = false;
            if (dateimage != null && dateimage.getDrawable() != null) {
                Bitmap bitmap = ((BitmapDrawable) dateimage.getDrawable()).getBitmap();
                if (bitmap != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    String base64 = Base64.encodeToString(byteArray, Base64.DEFAULT);
                    iEntity.setImage(base64);
                }
            }

            if (!nameTIET.getText().toString().isEmpty() && !descriptionTIET.getText().toString().isEmpty()
                    && !siteTIET.getText().toString().isEmpty() && !dateTIET.getText().toString().isEmpty()
                    && !phoneTIET.getText().toString().isEmpty() && !spinner.getSelectedItem().toString().isEmpty()) {
                flag2 = true;
            } else {
                Toast.makeText(this, R.string.empty_form_fields, Toast.LENGTH_SHORT).show();
                Log.d(TAG, "Empty form fields");
            }
            String result;
            iEntity.setResolved(switch1.isChecked());
            result = iEntity.setName(nameTIET.getText().toString());
            if (result.isEmpty()) {
                nameTIL.setError("");
            } else {
                nameTIL.setError(formPresenter.getError(result));
            }
            result = iEntity.setDescription(Objects.requireNonNull(descriptionTIET.getText()).toString());
            if (result.isEmpty()) {
                descriptionTIL.setError("");
            } else {
                descriptionTIL.setError(formPresenter.getError(result));
            }
            result = iEntity.setSite(Objects.requireNonNull(siteTIET.getText()).toString());
            if (result.isEmpty()) {
                siteTIL.setError("");
            } else {
                siteTIL.setError(formPresenter.getError(result));
            }
            result = iEntity.setDate(Objects.requireNonNull(dateTIET.getText()).toString());
            if (result.isEmpty()) {
                dateTIL.setError("");
            } else {
                dateTIL.setError(formPresenter.getError(result));
            }
            result = iEntity.setPhone(Objects.requireNonNull(phoneTIET.getText()).toString());
            if (result.isEmpty()) {
                phoneTIL.setError("");
            } else {
                phoneTIL.setError(formPresenter.getError(result));
            }
            iEntity.setSeverity(spinner.getSelectedItem().toString());
            if (flag2 && flag) {
                iEntity.setId(id);
                formPresenter.onClickSaveButton(iEntity, false);
            } else if (flag2) {
                formPresenter.onClickSaveButton(iEntity, true);
            }


        });
        dateimage.setOnClickListener(v -> {
            Log.d(TAG, "Click dateimagebutton pressed");
            formPresenter.onClickDateImageButton();
        });
        delete.setOnClickListener(v -> {
            Log.d(TAG, "Click delete button pressed");
            formPresenter.onClickDeleteButton();
        });
        addOptions.setOnClickListener(v -> {
            Log.d(TAG, "Click addoptions button pressed");
            formPresenter.onClickAddOptions();
        });
        photo.setOnClickListener(v -> {
            Log.d(TAG, "Click image button pressed");
            formPresenter.onClickImage();
        });
        empty.setOnClickListener(v -> {
            Log.d(TAG, "Click empty button pressed");
            photo.setImageBitmap(null);
            photo.setBackground(getDrawable(R.drawable.ic_notas));
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
                Log.d(TAG, "Help pressed");
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
    public void errorSavingForm() {
        Log.d(TAG, "error saving form");
        Toast.makeText(this, R.string.error_saving, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void saveForm() {
        Log.d(TAG, "save form");
        Toast.makeText(this, R.string.save_successfully, Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void showDialogDeleteForm() {
        Log.d(TAG, "onDialogDeleteForm");
        AlertDialog.Builder builder = new AlertDialog.Builder(FormActivity.this);
        builder.setTitle(R.string.delete);
        builder.setMessage(R.string.dialog_delete_form);
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                saveForm();
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
        Log.d(TAG, "on ShowDate");
        DatePickerDialog datePicker = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            final int actualMonth = month + 1;
            String dayFormated = (dayOfMonth < 10) ? zero + dayOfMonth : String.valueOf(dayOfMonth);
            String monthFormated = (actualMonth < 10) ? zero + actualMonth : String.valueOf(actualMonth);
            dateTIET.setText(dayFormated + bar + monthFormated + bar + year);
        }, year, month, day);
        datePicker.show();
    }

    @Override
    public void showDialogAddOptions() {
        Log.d(TAG, "onDialogAddOptions");
        AlertDialog.Builder builder = new AlertDialog.Builder(FormActivity.this);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams linear = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linear.setLayoutDirection(LinearLayout.VERTICAL);
        linear.setMargins(70, 30, 70, 50);
        builder.setTitle(R.string.add);
        builder.setMessage(R.string.show_dialog_add_options);
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        ll.addView(input, linear);
        builder.setView(ll);
        builder.setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                formPresenter.onAddOptions(input.getText().toString());
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
    public void addOptionsToSpinner(String text) {
        Log.d(TAG, "option added to spinner...");
        adapter.add(text);
        spinner.setSelection(adapter.getPosition(text));
    }

    @Override
    public void showErrorAddTextToSpinner() {
        Log.d(TAG, "showing error adding option to spinner...");
        Toast.makeText(this, R.string.text_cant_be_empty, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void selectImageFromGallery() {
        Log.d(TAG, "selecting image from gallery...");
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(
                Intent.createChooser(intent, getResources().getString(R.string.choose_image)),
                REQUEST_SELECT_IMAGE);
    }

    @Override
    public void showRequestPermission() {
        Log.d(TAG, "showing permissions gallery...");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(FormActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, CODE_WRITE_EXTERNAL_STORAGE_PERMISSION);
        } else {
            formPresenter.permissionDenied();
        }
    }

    @Override
    public void showError(String msg) {
        Snackbar.make(findViewById(R.id.coordinatorLayout), msg, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void imageSelected(Intent data) {
        Log.d(TAG, "image selected...");
        Uri selectedImage = data.getData();
        String selectedPath = selectedImage.getPath();
        if (selectedPath != null) {
            InputStream imageStream = null;
            try {
                imageStream = getContentResolver().openInputStream(selectedImage);
            } catch (FileNotFoundException e) {
            }
            Bitmap bmp = BitmapFactory.decodeStream(imageStream);
            Bitmap imageScaled = Bitmap.createScaledBitmap(bmp, 200, 200, false);
            photo.setBackground(null);
            photo.setImageBitmap(imageScaled);
        }
    }

    @Override
    public void showData(IncidencesEntity e) {
        nameTIET.setText(e.getName());
        siteTIET.setText(e.getSite());
        dateTIET.setText(e.getDate());
        phoneTIET.setText(e.getPhone());
        descriptionTIET.setText(e.getDescription());
        switch1.setChecked(e.isResolved());
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Log.d(TAG, "on request permissions");
        switch (requestCode) {
            case CODE_WRITE_EXTERNAL_STORAGE_PERMISSION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    formPresenter.permissionGranted();
                } else {
                    formPresenter.permissionDenied();
                }
                break;

            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.d(TAG, "on activity result");
        switch (requestCode) {
            case (REQUEST_SELECT_IMAGE):
                if (resultCode == Activity.RESULT_OK) {
                    formPresenter.imageSelected(data);
                } else {
                    formPresenter.imageNotSelected();
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}