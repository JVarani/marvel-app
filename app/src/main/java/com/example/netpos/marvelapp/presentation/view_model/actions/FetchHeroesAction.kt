package com.example.netpos.marvelapp.presentation.view_model.actions

import com.example.netpos.marvelapp.data.model.CharacterDataWrapper

/**
 * Created by bloder on 24/05/18.
 */
sealed class FetchHeroesAction {

    object StartToFetch : FetchHeroesAction()
    object ErrorToFetch : FetchHeroesAction()
    class HeroesFetched(heroes: CharacterDataWrapper) : FetchHeroesAction()
}