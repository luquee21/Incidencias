package com.incidences.incidencesapp.interfaces;

import android.content.Intent;

import com.incidences.incidencesapp.models.IncidencesEntity;

import java.util.ArrayList;

public interface IFormInterface {

    interface View {
        void errorSavingForm();

        void saveForm();

        void onClickHelp(String url);

        void showDialogDeleteForm();

        void showDate();

        void showDialogAddOptions();

        void addOptionsToSpinner(String text);

        void showErrorAddTextToSpinner();

        void selectImageFromGallery();

        void showRequestPermission();

        void showError(String msg);

        void imageSelected(Intent data);

        void showData(IncidencesEntity e);

    }

    interface Presenter {
        void onClickSaveButton(IncidencesEntity incidence, boolean flag);

        void onClickDeleteButton();

        void onClickDateImageButton();

        void onClickHelp(String url);

        void onClickAddOptions();

        void onAddOptions(String option);

        String getError(String error);

        void onClickImage();

        void permissionDenied();

        void permissionGranted();

        void imageSelected(Intent data);

        void imageNotSelected();

        void getItemById(String id);

        ArrayList<String> getSevereties();

        boolean deleteItem(String id);

    }
}
