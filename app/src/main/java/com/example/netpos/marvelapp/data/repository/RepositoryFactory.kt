package com.example.netpos.marvelapp.data.repository

import com.example.netpos.marvelapp.data.repository.resources.HeroesRepository

/**
 * Created by bloder on 24/05/18.
 */
interface RepositoryFactory {

    fun forHeroes() : HeroesRepository
}