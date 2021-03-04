package com.incidences.incidencesapp.presenters;

import com.incidences.incidencesapp.interfaces.ISearchInterface;
import com.incidences.incidencesapp.models.IncidencesModel;

import java.util.ArrayList;

public class SearchPresenter implements ISearchInterface.Presenter {
    private final ISearchInterface.View view;
    private final IncidencesModel incidencesModel = new IncidencesModel();

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

    @Override
    public ArrayList<String> getSeverities() {
        return incidencesModel.getSeverities();
    }

    @Override
    public void onClickHelp(String url) {
        view.onClickHelp(url);
    }
}
