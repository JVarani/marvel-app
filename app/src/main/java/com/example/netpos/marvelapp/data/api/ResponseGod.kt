package com.example.netpos.marvelapp.data.api

/**
 * Created by bloder on 24/05/18.
 */
interface ResponseGod {

    val responseMap get() = mapOf<Int, () -> Any>(
            200 to { on200() }
    )

    fun on200() {}
    fun onError() {}

    fun handle(code: Int) {
        if (responseMap[code] != null) responseMap[code]?.invoke()
        else onError()
    }
}