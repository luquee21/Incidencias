package com.incidences.incidencesapp.presenters;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;

import androidx.core.content.ContextCompat;

import com.incidences.incidencesapp.R;
import com.incidences.incidencesapp.interfaces.IFormInterface;
import com.incidences.incidencesapp.models.IncidencesEntity;
import com.incidences.incidencesapp.models.IncidencesModel;

public class FormPresenter implements IFormInterface.Presenter {
    private final IFormInterface.View view;
    private final Context context;
    private final static String TAG = "FormPresenter";
    private final IncidencesModel incidencesModel;


    public FormPresenter(IFormInterface.View view, Context context) {
        this.view = view;
        this.context = context;
        this.incidencesModel = new IncidencesModel();
    }

    @Override
    public void onClickSaveButton(IncidencesEntity incidence) {
        if (incidencesModel.insert(incidence)) {
            view.saveForm();
        } else {
            view.errorSavingForm();
        }
    }

    @Override
    public void onClickDeleteButton() {
        view.showDialogDeleteForm();
    }

    @Override
    public void onClickDateImageButton() {
        view.showDate();
    }

    @Override
    public void onClickAddOptions() {
        view.showDialogAddOptions();
    }


    @Override
    public void onAddOptions(String option) {
        if (option != null && !option.isEmpty()) {
            view.addOptionsToSpinner(option);
        } else {
            view.showErrorAddTextToSpinner();
        }
    }

    @Override
    public String getError(String error) {
        String err_msg = "";
        switch (error) {
            case "name_empty":
                err_msg = context.getResources().getString(R.string.name_cant_empty);
                break;
            case "name_bad_format":
                err_msg = context.getResources().getString(R.string.name_only_letter_numbers);
                break;
            case "site_empty":
                err_msg = context.getResources().getString(R.string.site_cant_empty);
                break;
            case "site_bad_format":
                err_msg = context.getResources().getString(R.string.site_only_letter_numbers);
                break;
            case "phone_empty":
                err_msg = context.getResources().getString(R.string.phone_cant_empty);
                break;
            case "phone_only_numbers":
                err_msg = context.getResources().getString(R.string.phone_only_numbers);
                break;
            case "phone_only_9_digits":
                err_msg = context.getResources().getString(R.string.phone_too_long);
                break;
            case "date_empty":
                err_msg = context.getResources().getString(R.string.date_cant_empty);
                break;
            case "date_bad_format":
                err_msg = context.getResources().getString(R.string.date_error_formated);
                break;
            case "description_empty":
                err_msg = context.getResources().getString(R.string.description_cant_empty);
                break;


        }

        return err_msg;
    }

    @Override
    public void onClickImage() {
        int WriteExternalStoragePermission = ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        Log.d(TAG, "WRITE_EXTERNAL_STORAGE Permission: " + WriteExternalStoragePermission);
        if (WriteExternalStoragePermission != PackageManager.PERMISSION_GRANTED) {
            view.showRequestPermission();
        } else {
            view.selectImageFromGallery();
        }
    }

    @Override
    public void permissionDenied() {
        Log.d(TAG, "permissions denied...");
        view.showError(context.getResources().getString(R.string.error_permission_gallery));
    }

    @Override
    public void permissionGranted() {
        Log.d(TAG, "permissions granted...");
        view.selectImageFromGallery();
    }

    @Override
    public void imageSelected(Intent data) {
        Log.d(TAG, "image selected...");
        view.imageSelected(data);
    }

    @Override
    public void imageNotSelected() {
        Log.d(TAG, "image not selected...");
        view.showError(context.getResources().getString(R.string.image_not_selected));
    }


}



