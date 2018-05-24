package com.example.netpos.marvelapp.data.repository.production.heroes

import com.example.netpos.marvelapp.data.model.CharacterDataWrapper
import com.example.netpos.marvelapp.data.repository.resources.HeroesRepository
import io.reactivex.Single

/**
 * Created by bloder on 24/05/18.
 */
class ProductionHeroesRepository : HeroesRepository {

    override fun getHeroes(): Single<CharacterDataWrapper> {
        return Single.just(CharacterDataWrapper())
    }
}