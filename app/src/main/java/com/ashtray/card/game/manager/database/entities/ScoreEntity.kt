package com.ashtray.card.game.manager.database.entities

data class ScoreEntity(
    val scoreId: Int,
    val gameId: Int,
    val scoreInfo: String
)