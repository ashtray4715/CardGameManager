package com.ashtray.card.game.manager.apps

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ashtray.card.game.manager.features.hazari.AddHazariGameViewModel
import com.ashtray.card.game.manager.features.home.HomeViewModel
import com.ashtray.card.game.manager.features.ninecard.AddNineCardGameViewModel
import com.ashtray.card.game.manager.features.splash.SplashScreenViewModel

@Suppress("UNCHECKED_CAST")
class MyViewModelFactory(
    private val repository: MyRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            AddHazariGameViewModel::class.java -> AddHazariGameViewModel(repository) as T
            AddNineCardGameViewModel::class.java -> AddNineCardGameViewModel(repository) as T
            HomeViewModel::class.java -> HomeViewModel(repository) as T
            SplashScreenViewModel::class.java -> SplashScreenViewModel(repository) as T
            else -> throw IllegalArgumentException("viewmodel class not found")
        }
    }
}