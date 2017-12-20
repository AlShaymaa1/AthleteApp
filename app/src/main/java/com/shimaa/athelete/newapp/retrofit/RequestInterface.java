package com.shimaa.athelete.newapp.retrofit;

import com.shimaa.athelete.newapp.model.JSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("Bassem-Samy/f227855df4d197d3737c304e9377c4d4/raw/ece2a30b16a77ee58091886bf6d3445946e10a23/athletes.josn")
    Call<JSONResponse> getJSON();
}