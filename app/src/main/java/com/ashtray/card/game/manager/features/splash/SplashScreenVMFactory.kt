package com.ashtray.card.game.manager.features.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ashtray.card.game.manager.apps.MyRepository

@Suppress("UNCHECKED_CAST")
class SplashScreenVMFactory(
    private val repository: MyRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SplashScreenViewModel(repository) as T
    }
}