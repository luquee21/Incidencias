package com.incidences.incidencesapp.presenters;

import com.incidences.incidencesapp.interfaces.IMainInterface;

public class MainPresenter implements IMainInterface.Presenter {
    private final IMainInterface.View view;

    public MainPresenter(IMainInterface.View view) {
        this.view = view;
    }

    @Override
    public void onClickFloatingButton() {
        view.startFormActivity();
    }

    @Override
    public void onClickAbout() {
        view.startAboutActivity();
    }

    @Override
    public void onClickSearch() {
        view.startSearchActivity();
    }
}
