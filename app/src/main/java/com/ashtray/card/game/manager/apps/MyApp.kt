package com.ashtray.card.game.manager.apps

import android.app.Application

class MyApp : Application() {
    companion object {
        val repository = MyRepository()
        val fragmentFactory = MyFragmentFactory()
    }
}