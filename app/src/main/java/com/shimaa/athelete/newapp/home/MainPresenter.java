package com.shimaa.athelete.newapp.home;


public interface MainPresenter<V> {

    void attachedView(V view);

    void detachView();

    void getItems();
}
