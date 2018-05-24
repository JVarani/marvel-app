package com.example.netpos.marvelapp.data.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by bloder on 24/05/18.
 */
abstract class MarvelApi<out T> {

    protected val retrofit: Retrofit by lazy {
        Retrofit.Builder()
                .baseUrl("http://gateway.marvel.com/v1/public/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    protected val service by lazy { buildService() }

    abstract fun buildService() : T
}