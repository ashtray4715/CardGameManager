package com.ashtray.card.game.manager.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hazari_game_info")
data class HazariGameInfo(

    @PrimaryKey
    @ColumnInfo("game_id")
    val gameId: Long,

    @ColumnInfo("game_name")
    val gameName: String,

    @ColumnInfo("creation_time")
    val creationTime: Long,

    @ColumnInfo("player_name1")
    val playerName1: String,

    @ColumnInfo("player_name2")
    val playerName2: String,

    @ColumnInfo("player_name3")
    val playerName3: String,

    @ColumnInfo("player_name4")
    val playerName4: String,

    @ColumnInfo("target_score")
    val targetScore: Int
)