package com.ashtray.card.game.manager.features.hazari

import androidx.lifecycle.ViewModel
import com.ashtray.card.game.manager.database.entities.HazariGameInfo
import com.ashtray.card.game.manager.features.common.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddHazariGameViewModel @Inject constructor(
    private val repository: MyRepository
) : ViewModel() {
    suspend fun insertNewHazariGame(game: HazariGameInfo) {
        repository.insertNewHazariGame(game)
    }
}