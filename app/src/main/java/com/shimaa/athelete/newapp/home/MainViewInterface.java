package com.shimaa.athelete.newapp.home;

import com.shimaa.athelete.newapp.model.AthelteModel;

import java.util.ArrayList;

/**
 * Created by Green on 28/11/2017.
 */

public interface MainViewInterface {
    void setItems(ArrayList<AthelteModel> pictureList);

    void showProgress();

    void hideProgress();

    void showMessage(String message);
}
