package com.ashtray.card.game.manager.common.helpers

import com.ashtray.card.game.manager.apps.MyConst

object CustomInputFilter {
    fun checkGameName(gameName: String): String {
        if (gameName.length < MyConst.GAME_NAME_MINIMUM_LENGTH) {
            throw Exception("Game name minimum length is ${MyConst.GAME_NAME_MINIMUM_LENGTH}")
        }
        if (gameName.length > MyConst.GAME_NAME_MAXIMUM_LENGTH) {
            throw Exception("Game name maximum length is ${MyConst.GAME_NAME_MAXIMUM_LENGTH}")
        }
        return gameName
    }

    fun checkHazariGameFinalScore(score: String): Int {
        if (score.isEmpty()) {
            throw Exception("Final score can not be empty")
        }
        for (ch in score.toCharArray()) {
            if (ch < '0' || '9' < ch) {
                throw Exception("Only 0 ~ 9 accepted")
            }
        }
        return score.toInt()
    }

    fun checkPlayerName(name: String): String {
        if (name.isEmpty()) {
            throw Exception("Player name can not be empty")
        }
        if (name.length < MyConst.PLAYER_NAME_MINIMUM_LENGTH) {
            throw Exception("Player name minimum length is ${MyConst.PLAYER_NAME_MINIMUM_LENGTH}")
        }
        if (name.length > MyConst.PLAYER_NAME_MAXIMUM_LENGTH) {
            throw Exception("Player name maximum length is ${MyConst.PLAYER_NAME_MAXIMUM_LENGTH}")
        }
        return name
    }
}