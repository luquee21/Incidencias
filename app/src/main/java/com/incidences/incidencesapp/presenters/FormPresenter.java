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

    @Override
    public void onClickDeleteButton() {
        view.showDialogDeleteForm();
    }

    @Override
    public void onClickDateImageButton() {
        view.showDate();
    }

    @Override
    public void onClickAddOptions() {
        view.showDialogAddOptions();
    }


    @Override
    public void onAddOptions(String option) {
        if (option != null && !option.isEmpty()) {
            view.addOptionsToSpinner(option);
        } else {
            view.showErrorAddTextToSpinner();
        }
    }
}
