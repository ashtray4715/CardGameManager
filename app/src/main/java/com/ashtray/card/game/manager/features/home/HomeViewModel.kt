package com.ashtray.card.game.manager.features.home

import androidx.lifecycle.ViewModel
import com.ashtray.card.game.manager.features.common.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(repository: MyRepository) : ViewModel() {

}