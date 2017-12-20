package com.shimaa.athelete.newapp.retrofit;

import android.util.Log;

import com.shimaa.athelete.newapp.model.JSONResponse;
import com.shimaa.athelete.newapp.model.AthelteModel;
import com.shimaa.athelete.newapp.home.listeners.LoaderListener;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Green on 28/11/2017.
 */

public class AtheletInteractor implements Interactor {

    ArrayList<AthelteModel> items = new ArrayList<>();

    public void loadItems(final LoaderListener loaderListener) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gist.githubusercontent.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<JSONResponse> call = request.getJSON();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                Log.e("athelete", jsonResponse.toString());
                items = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                loaderListener.onItemsRetrived(items);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.e("athelete", t.getMessage().toString());
            }
        });
    }

}




