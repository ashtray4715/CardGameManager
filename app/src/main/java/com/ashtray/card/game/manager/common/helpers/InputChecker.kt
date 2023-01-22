package com.ashtray.card.game.manager.common.helpers

import com.ashtray.card.game.manager.apps.MyConst

object InputChecker {
    fun checkGameName(gameName: String): String {
        if (gameName.length < MyConst.GAME_NAME_MINIMUM_LENGTH) {
            throw Exception("Minimum length is ${MyConst.GAME_NAME_MINIMUM_LENGTH}")
        }
        if (gameName.length > MyConst.GAME_NAME_MAXIMUM_LENGTH) {
            throw Exception("Maximum length is ${MyConst.GAME_NAME_MAXIMUM_LENGTH}")
        }
        return gameName
    }

    fun checkHazariGameFinalScore(score: String): Int {
        if (score.isEmpty()) {
            throw Exception("Can not be empty")
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
            throw Exception("Can not be empty")
        }
        if (name.length < MyConst.PLAYER_NAME_MINIMUM_LENGTH) {
            throw Exception("Minimum length is ${MyConst.PLAYER_NAME_MINIMUM_LENGTH}")
        }
        if (name.length > MyConst.PLAYER_NAME_MAXIMUM_LENGTH) {
            throw Exception("Maximum length is ${MyConst.PLAYER_NAME_MAXIMUM_LENGTH}")
        }
        return name
    }
}