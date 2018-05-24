package com.example.netpos.marvelapp.domain

import com.example.netpos.marvelapp.data.model.CharacterDataWrapper
import com.example.netpos.marvelapp.data.repository.MarvelRepository
import io.reactivex.Single

/**
 * Created by bloder on 24/05/18.
 */
class HeroesUseCase : HeroesUseCaseContract {

    override fun getHeroes(apiKey: String, ts: String, hash: String): Single<CharacterDataWrapper> = MarvelRepository.get().forHeroes().fetchHeroes(apiKey, ts, hash)
}