package com.shimaa.athelete.newapp.home.listeners;

import com.shimaa.athelete.newapp.model.AthelteModel;

import java.util.ArrayList;


public interface LoaderListener {

    void onItemsRetrived(ArrayList<AthelteModel> pictureList);
}
