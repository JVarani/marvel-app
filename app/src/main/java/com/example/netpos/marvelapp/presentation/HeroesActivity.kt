package com.example.netpos.marvelapp.presentation

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.netpos.marvelapp.R
import com.example.netpos.marvelapp.data.model.CharacterDataWrapper
import com.example.netpos.marvelapp.presentation.view_model.HeroesViewModel
import com.example.netpos.marvelapp.presentation.view_model.actions.FetchHeroesAction
import kotlinx.android.synthetic.main.activity_main.*

class HeroesActivity : AppCompatActivity() {

    private var heroesViewModel: HeroesViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        heroesViewModel = ViewModelProviders.of(this).get(HeroesViewModel::class.java)
        waitForFetchingResponse()
        refresh_heroes.setOnRefreshListener { fetchHeroes() }
        fetchHeroes()
    }

    private fun fetchHeroes() = heroesViewModel?.fetchHeroes()

    private fun waitForFetchingResponse() = heroesViewModel?.fetchingResponse()?.observe(this, Observer { action -> when (action) {
        is FetchHeroesAction.StartToFetch -> { onStartToFetchHeroes() }
        is FetchHeroesAction.HeroesFetched -> { onHeroesFetched(action.heroes) }
        is FetchHeroesAction.ErrorToFetch -> { onErrorToFetchHeroes() }
    }})

    private fun onStartToFetchHeroes() {
        refresh_heroes.isRefreshing = true
        error_text.visibility = View.GONE
    }

    private fun onHeroesFetched(heroes: CharacterDataWrapper) {
        refresh_heroes.isRefreshing = false
        hero_list.layoutManager = LinearLayoutManager(this)
        hero_list.adapter = HeroesAdapter(this, heroes.data.results)
        hero_list.visibility = View.VISIBLE
    }

    private fun onErrorToFetchHeroes() {
        hero_list.visibility = View.GONE
        refresh_heroes.isRefreshing = false
        error_text.visibility = View.VISIBLE
    }
}
