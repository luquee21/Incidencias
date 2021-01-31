package com.incidences.incidencesapp.interfaces;

import java.util.ArrayList;

public interface ISearchInterface {

    interface View {
        void finishSearchActivity();

        void showDate();
    }

    interface Presenter {
        void onClickSearch();

        void onClickDate();

        ArrayList<String> getSeverities();
    }

}
