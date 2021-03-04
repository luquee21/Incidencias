package com.incidences.incidencesapp.interfaces;

import java.util.ArrayList;

public interface ISearchInterface {

    interface View {
        void finishSearchActivity();

        void showDate();

        void onClickHelp(String url);

    }

    interface Presenter {
        void onClickSearch();

        void onClickDate();

        ArrayList<String> getSeverities();

        void onClickHelp(String url);
    }

}
