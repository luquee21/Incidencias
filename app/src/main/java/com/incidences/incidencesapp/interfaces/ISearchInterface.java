package com.incidences.incidencesapp.interfaces;

public interface ISearchInterface {

    interface View {
        void finishSearchActivity();

        void showDate();
    }

    interface Presenter {
        void onClickSearch();

        void onClickDate();
    }

}
