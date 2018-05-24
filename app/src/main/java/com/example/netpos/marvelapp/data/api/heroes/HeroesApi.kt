package com.example.netpos.marvelapp.data.api.heroes

import com.example.netpos.marvelapp.data.api.MarvelApi
import com.example.netpos.marvelapp.data.api.heroes.response.HeroesResponse
import com.example.netpos.marvelapp.data.model.CharacterDataWrapper
import io.reactivex.Single

/**
 * Created by bloder on 24/05/18.
 */
class HeroesApi : MarvelApi<HeroesService>() {

    override fun buildService(): HeroesService = retrofit.create(HeroesService::class.java)

    fun fetchHeroes(apiKey: String, ts: String, hash: String) : Single<CharacterDataWrapper> = service
            .fetchHeroes(ts, apiKey, hash)
            .flatMap { response ->
                Single.create<CharacterDataWrapper> { emitter ->
                    HeroesResponse(response.body(), emitter).handle(response.code())
                }
            }
}