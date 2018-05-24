package com.example.netpos.marvelapp.domain

import com.example.netpos.marvelapp.data.model.CharacterDataWrapper
import com.example.netpos.marvelapp.data.repository.MarvelRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by bloder on 24/05/18.
 */
class HeroesUseCase : HeroesUseCaseContract {

    override fun getHeroes(): Single<CharacterDataWrapper> = MarvelRepository.get()
            .forHeroes()
            .getHeroes()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
}