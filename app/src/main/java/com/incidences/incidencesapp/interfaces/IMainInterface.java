package com.incidences.incidencesapp.interfaces;

public interface IMainInterface {

    interface View {
        void startFormActivity();

        void startAboutActivity();

        void startSearchActivity();
    }

    interface Presenter {
        void onClickFloatingButton();

        void onClickAbout();

        void onClickSearch();
    }
}
