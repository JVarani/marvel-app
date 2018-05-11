package com.example.netpos.marvelapp.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private final Retrofit retrofit;

    public APIClient() {

        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://gateway.marvel.com/v1/public/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public IRest getAPIClient() {
        return this.retrofit.create(IRest.class);
    }
}
