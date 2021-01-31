package com.incidences.incidencesapp.presenters;

import com.incidences.incidencesapp.interfaces.IMainInterface;
import com.incidences.incidencesapp.models.IncidencesEntity;
import com.incidences.incidencesapp.models.IncidencesModel;

import java.util.ArrayList;

public class MainPresenter implements IMainInterface.Presenter {
    private final IMainInterface.View view;
    private final IncidencesModel incidencesModel = new IncidencesModel();


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

    @Override
    public void onClickItem(String id) {
        view.onItemClicked(id);
    }

    @Override
    public void onSwipe(int position) {
        view.swiped(position);
    }

    @Override
    public ArrayList<IncidencesEntity> getItems() {
        return incidencesModel.getAllSummarize();
    }

    @Override
    public boolean insertItems(IncidencesEntity entity) {
        return incidencesModel.insert(entity);
    }

    @Override
    public boolean deleteItems(IncidencesEntity entity) {
        return incidencesModel.delete(entity);
    }

    @Override
    public ArrayList<IncidencesEntity> getItemsByCriteria(String criteria, String type) {
        if (criteria.equals("severity")) {
            return incidencesModel.getItemsBySeverity(type);
        } else if (criteria.equals("title")) {
            return incidencesModel.getItemsByName(type);
        } else if (criteria.equals("date")) {
            return incidencesModel.getItemsByDate(type);
        }
        return null;
    }

    @Override
    public ArrayList<IncidencesEntity> getItemsByAllCriterias(String severity, String date, String title) {
        return incidencesModel.getItemsByAllCriterias(severity, date, title);
    }
}
