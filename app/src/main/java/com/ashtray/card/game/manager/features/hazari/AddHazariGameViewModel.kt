package com.ashtray.card.game.manager.features.hazari

import androidx.lifecycle.ViewModel
import com.ashtray.card.game.manager.apps.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddHazariGameViewModel @Inject constructor(repository: MyRepository) : ViewModel() {
}