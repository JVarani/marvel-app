package com.example.netpos.marvelapp.service;

import com.example.netpos.marvelapp.model.Characters;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IRest {

    @GET("characters/{apikey}")
    Call<Characters> getCharacters(@Path("apikey") String apikey);
}
