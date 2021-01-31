package com.incidences.incidencesapp.interfaces;

import com.incidences.incidencesapp.models.IncidencesEntity;

import java.util.ArrayList;

public interface IMainInterface {

    interface View {
        void startFormActivity();

        void startAboutActivity();

        void startSearchActivity();

        void onItemClicked(String id);

        void swiped(int position);

    }

    interface Presenter {
        void onClickFloatingButton();

        void onClickAbout();

        void onClickSearch();

        void onClickItem(String id);

        void onSwipe(int position);

        ArrayList<IncidencesEntity> getItems();

        boolean insertItems(IncidencesEntity entity);

        boolean deleteItems(IncidencesEntity entity);

        ArrayList<IncidencesEntity> getItemsByCriteria(String criteria, String type);

        ArrayList<IncidencesEntity> getItemsByAllCriterias(String severity, String date, String title);
    }
}
