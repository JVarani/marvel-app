package com.example.netpos.marvelapp.presentation.view_model

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.netpos.marvelapp.BuildConfig
import com.example.netpos.marvelapp.domain.HeroesUseCase
import com.example.netpos.marvelapp.presentation.view_model.actions.FetchHeroesAction
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

/**
 * Created by bloder on 24/05/18.
 */
class HeroesViewModel : ViewModel() {

    private val heroesUseCase by lazy { HeroesUseCase() }
    private val disposable    by lazy { CompositeDisposable() }
    private val fetchLiveData by lazy { MutableLiveData<FetchHeroesAction>()}

    fun fetchingResponse() : MutableLiveData<FetchHeroesAction> = fetchLiveData

    fun fetchHeroes() = disposable.add(heroesUseCase.getHeroes(BuildConfig.API_KEY, BuildConfig.TS, BuildConfig.HASH)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { fetchLiveData.value = FetchHeroesAction.StartToFetch }
            .subscribeBy(
                    onError = { fetchLiveData.value = FetchHeroesAction.ErrorToFetch },
                    onSuccess = { heroes -> fetchLiveData.value = FetchHeroesAction.HeroesFetched(heroes) }
            )
    )

    override fun onCleared() {
        disposable.clear()
    }
}