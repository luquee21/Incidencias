package com.incidences.incidencesapp.interfaces;

import android.content.Intent;

public interface IFormInterface {

    interface View {
        void finishFormActivity();

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
        void onClickSaveButton();

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
