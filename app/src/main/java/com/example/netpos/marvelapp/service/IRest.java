package com.example.netpos.marvelapp.service;

import com.example.netpos.marvelapp.model.CharacterDataWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IRest {

    @GET("characters")
    Call<CharacterDataWrapper> getCharacters(@Query("ts") String ts, @Query("apikey") String apikey, @Query("hash") String hash);
}
