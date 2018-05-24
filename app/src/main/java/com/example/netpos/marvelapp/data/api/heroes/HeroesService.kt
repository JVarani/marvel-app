package com.example.netpos.marvelapp.data.api.heroes

import com.example.netpos.marvelapp.data.model.CharacterDataWrapper
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by bloder on 24/05/18.
 */
interface HeroesService {

    @GET("characters")
    fun fetchHeroes(@Query("ts") ts: String, @Query("apikey") apikey: String, @Query("hash") hash: String): Single<Response<CharacterDataWrapper>>
}