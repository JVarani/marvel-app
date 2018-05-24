package com.example.netpos.marvelapp.data.repository

import com.example.netpos.marvelapp.data.repository.production.ProductionFactory

/**
 * Created by bloder on 24/05/18.
 */
class MarvelRepository {

    companion object Provider {
        fun get() : RepositoryFactory = ProductionFactory()
    }
}