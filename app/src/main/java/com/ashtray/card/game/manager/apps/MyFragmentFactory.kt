package com.ashtray.card.game.manager.apps

import com.ashtray.card.game.manager.features.home.HomeScreenFragment
import com.ashtray.card.game.manager.features.splash.SplashScreenFragment

class MyFragmentFactory {

    fun getSplashScreenFragment() = SplashScreenFragment()

    fun getHomeScreenFragment() = HomeScreenFragment()
}