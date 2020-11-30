package com.incidences.incidencesapp.presenters;

import com.incidences.incidencesapp.interfaces.ISearchInterface;

public class SearchPresenter implements ISearchInterface.Presenter {
    private final ISearchInterface.View view;

    public SearchPresenter(ISearchInterface.View view) {
        this.view = view;
    }

    @Override
    public void onClickSearch() {
        view.finishSearchActivity();
    }

    @Override
    public void onClickDate() {
        view.showDate();
    }
}
