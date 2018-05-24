package com.example.netpos.marvelapp.data.repository.production.heroes

import com.example.netpos.marvelapp.data.api.heroes.HeroesApi
import com.example.netpos.marvelapp.data.model.CharacterDataWrapper
import com.example.netpos.marvelapp.data.repository.resources.HeroesRepository
import io.reactivex.Single

/**
 * Created by bloder on 24/05/18.
 */
class ProductionHeroesRepository : HeroesRepository {

    private val heroesApi by lazy { HeroesApi() }

    override fun fetchHeroes(apiKey: String, ts: String, hash: String): Single<CharacterDataWrapper> = heroesApi.fetchHeroes(apiKey, ts, hash)
}