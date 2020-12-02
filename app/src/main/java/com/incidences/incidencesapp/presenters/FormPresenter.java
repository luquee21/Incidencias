package com.incidences.incidencesapp.presenters;

import android.content.Context;

import com.incidences.incidencesapp.R;
import com.incidences.incidencesapp.interfaces.IFormInterface;

public class FormPresenter implements IFormInterface.Presenter {
    private final IFormInterface.View view;
    private final Context context;

    public FormPresenter(IFormInterface.View view, Context context) {
        this.view = view;
        this.context = context;
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

    @Override
    public String getError(String error) {
        String err_msg = "";
        switch (error) {
            case "name_empty":
                err_msg = context.getResources().getString(R.string.name_cant_empty);
                break;
            case "name_bad_format":
                err_msg = context.getResources().getString(R.string.name_only_letter_numbers);
                break;
            case "site_empty":
                err_msg = context.getResources().getString(R.string.site_cant_empty);
                break;
            case "site_bad_format":
                err_msg = context.getResources().getString(R.string.site_only_letter_numbers);
                break;
            case "phone_empty":
                err_msg = context.getResources().getString(R.string.phone_cant_empty);
                break;
            case "phone_only_numbers":
                err_msg = context.getResources().getString(R.string.phone_only_numbers);
                break;
            case "phone_only_9_digits":
                err_msg = context.getResources().getString(R.string.phone_too_long);
                break;
            case "date_empty":
                err_msg = context.getResources().getString(R.string.date_cant_empty);
                break;
            case "date_bad_format":
                err_msg = context.getResources().getString(R.string.date_error_formated);
                break;
            case "description_empty":
                err_msg = context.getResources().getString(R.string.description_cant_empty);
                break;


        }

        return err_msg;
    }
}
