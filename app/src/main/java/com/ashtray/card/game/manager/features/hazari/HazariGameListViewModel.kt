package com.ashtray.card.game.manager.features.hazari

import androidx.lifecycle.ViewModel
import com.ashtray.card.game.manager.features.common.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HazariGameListViewModel @Inject constructor(
    private val repository: MyRepository
) : ViewModel() {

}