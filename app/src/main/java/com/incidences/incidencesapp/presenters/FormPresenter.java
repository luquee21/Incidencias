package com.incidences.incidencesapp.presenters;

import com.incidences.incidencesapp.interfaces.IFormInterface;

public class FormPresenter implements IFormInterface.Presenter {
    private final IFormInterface.View view;

    public FormPresenter(IFormInterface.View view) {
        this.view = view;
    }

    @Override
    public void onClickSaveButton() {
        view.finishFormActivity();
    }
}
