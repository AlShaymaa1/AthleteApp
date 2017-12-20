package com.shimaa.athelete.newapp.home;

import com.shimaa.athelete.newapp.retrofit.AtheletInteractor;
import com.shimaa.athelete.newapp.model.AthelteModel;
import com.shimaa.athelete.newapp.home.listeners.LoaderListener;

import java.util.ArrayList;

/**
 * Created by Green on 28/11/2017.
 */

public class MainPresenterIml implements MainPresenter<MainViewInterface>, LoaderListener {

    private MainViewInterface mvPview;
    private AtheletInteractor atheletInteractor;

    @Override
    public void attachedView(MainViewInterface view) {
        if (view == null)
            throw new IllegalArgumentException("You can't set a null view");

        mvPview = view;
    }

    @Override
    public void detachView() {
        mvPview = null;
    }

    @Override
    public void getItems() {
        mvPview.showProgress();
        atheletInteractor = new AtheletInteractor();
        atheletInteractor.loadItems(this);
    }

    @Override
    public void onItemsRetrived(ArrayList<AthelteModel> items) {
        mvPview.setItems(items);
        mvPview.hideProgress();
    }
}
