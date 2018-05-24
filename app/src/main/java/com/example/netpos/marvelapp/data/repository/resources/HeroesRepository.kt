package com.example.netpos.marvelapp.data.repository.resources

import com.example.netpos.marvelapp.data.model.CharacterDataWrapper
import io.reactivex.Single

/**
 * Created by bloder on 24/05/18.
 */
interface HeroesRepository {

    fun getHeroes() : Single<CharacterDataWrapper>
}