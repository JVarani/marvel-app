package com.example.netpos.marvelapp.domain

import com.example.netpos.marvelapp.data.model.CharacterDataWrapper
import io.reactivex.Single

/**
 * Created by bloder on 24/05/18.
 */
interface HeroesUseCaseContract {

    fun getHeroes(apiKey: String, ts: String, hash: String) : Single<CharacterDataWrapper>
}