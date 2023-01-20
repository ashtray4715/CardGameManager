package com.ashtray.card.game.manager.apps

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application() {
    companion object {
        val repository = MyRepository()
        val fragmentFactory = MyFragmentFactory()
    }
}