package com.ashtray.card.game.manager.apps

import android.app.Application

class MyApp : Application() {

    val repository = MyRepository()
}