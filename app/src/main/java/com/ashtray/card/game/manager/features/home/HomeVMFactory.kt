package com.ashtray.card.game.manager.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ashtray.card.game.manager.apps.MyRepository

@Suppress("UNCHECKED_CAST")
class HomeVMFactory(
    private val repository: MyRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(repository) as T
    }
}
