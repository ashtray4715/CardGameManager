package com.ashtray.card.game.manager.features.ninecard

import androidx.lifecycle.ViewModel
import com.ashtray.card.game.manager.apps.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddNineCardGameViewModel @Inject constructor(repository: MyRepository) : ViewModel() {
}