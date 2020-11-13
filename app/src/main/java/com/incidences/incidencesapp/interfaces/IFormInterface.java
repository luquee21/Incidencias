package com.incidences.incidencesapp.interfaces;

public interface IFormInterface {

    interface View {
        void finishFormActivity();
    }

    interface Presenter {
        void onClickSaveButton();
    }
}
