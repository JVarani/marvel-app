package com.example.netpos.marvelapp.data.api.heroes.response

import com.example.netpos.marvelapp.data.api.ResponseGod
import com.example.netpos.marvelapp.data.model.CharacterDataWrapper
import io.reactivex.SingleEmitter

/**
 * Created by bloder on 24/05/18.
 */
class HeroesResponse(private val response: CharacterDataWrapper?, private val single: SingleEmitter<CharacterDataWrapper>) : ResponseGod {

    override fun on200() = single.onSuccess(response!!)
    override fun onError() = single.onError(Exception())
}