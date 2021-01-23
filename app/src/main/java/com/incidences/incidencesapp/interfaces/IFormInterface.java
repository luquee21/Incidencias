package com.incidences.incidencesapp.interfaces;

import android.content.Intent;

import com.incidences.incidencesapp.models.IncidencesEntity;

public interface IFormInterface {

    interface View {
        void errorSavingForm();

        void saveForm();

        void showDialogDeleteForm();

        void showDate();

        void showDialogAddOptions();

        void addOptionsToSpinner(String text);

        void showErrorAddTextToSpinner();

        void selectImageFromGallery();

        void showRequestPermission();

        void showError(String msg);

        void imageSelected(Intent data);

    }

    interface Presenter {
        void onClickSaveButton(IncidencesEntity incidence);

        void onClickDeleteButton();

        void onClickDateImageButton();

        void onClickAddOptions();

        void onAddOptions(String option);

        String getError(String error);

        void onClickImage();

        void permissionDenied();

        void permissionGranted();

        void imageSelected(Intent data);

        void imageNotSelected();

    }
}
