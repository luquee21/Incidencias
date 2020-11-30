package com.incidences.incidencesapp.interfaces;

public interface IFormInterface {

    interface View {
        void finishFormActivity();

        void showDialogDeleteForm();

        void showDate();
    }

    interface Presenter {
        void onClickSaveButton();

        void onClickDeleteButton();

        void onClickDateImageButton();
    }
}
