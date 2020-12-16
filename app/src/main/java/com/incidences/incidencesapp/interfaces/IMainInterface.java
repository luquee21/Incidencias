package com.incidences.incidencesapp.interfaces;

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

    }
}
