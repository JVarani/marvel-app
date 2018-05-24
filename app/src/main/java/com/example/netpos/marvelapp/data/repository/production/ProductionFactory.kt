package com.example.netpos.marvelapp.data.repository.production

import com.example.netpos.marvelapp.data.repository.RepositoryFactory
import com.example.netpos.marvelapp.data.repository.production.heroes.ProductionHeroesRepository
import com.example.netpos.marvelapp.data.repository.resources.HeroesRepository

/**
 * Created by bloder on 24/05/18.
 */
class ProductionFactory : RepositoryFactory {

    override fun forHeroes(): HeroesRepository = ProductionHeroesRepository()
}