package com.incidences.incidencesapp.interfaces;

public interface IFormInterface {

    interface View {
        void finishFormActivity();

        void showDialogDeleteForm();

        void showDate();

        void showDialogAddOptions();

        void addOptionsToSpinner(String text);

        void showErrorAddTextToSpinner();
    }

    interface Presenter {
        void onClickSaveButton();

        void onClickDeleteButton();

        void onClickDateImageButton();

        void onClickAddOptions();

        void onAddOptions(String option);
    }
}
