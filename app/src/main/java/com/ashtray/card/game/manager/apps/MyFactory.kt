package com.ashtray.card.game.manager.apps

import android.os.Bundle
import com.ashtray.card.game.manager.features.hazari.PlayHazariGameFragment

object MyFactory {
    fun getPlayHazariGameFragment(gameId: Long) : PlayHazariGameFragment {
        return PlayHazariGameFragment().also {
            it.arguments = Bundle().apply {
                putLong(MyConst.PK_SELECTED_GAME_ID, gameId)
            }
        }
    }
}