package com.ashtray.card.game.manager.features.hazari

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashtray.card.game.manager.database.entities.HazariGameInfo
import com.ashtray.card.game.manager.features.common.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddHazariGameViewModel @Inject constructor(
    private val repository: MyRepository
) : ViewModel() {

    private val _isGameInsertionDone = MutableLiveData(-1L)
    val isGameInsertionDone: LiveData<Long> get() = _isGameInsertionDone

    fun insertNewHazariGame(game: HazariGameInfo) {
        viewModelScope.launch {
            val newGameId = repository.insertNewHazariGame(game)
            _isGameInsertionDone.postValue(newGameId)
        }
    }
}