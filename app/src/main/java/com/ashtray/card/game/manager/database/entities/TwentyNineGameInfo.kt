package com.ashtray.card.game.manager.database.entities

data class TwentyNineGameInfo(
    val gameId: Long,
    val gameName: String,
    val creationTime: Long,
    val playerName1: String,
    val playerName2: String,
    val playerName3: String,
    val playerName4: String
)