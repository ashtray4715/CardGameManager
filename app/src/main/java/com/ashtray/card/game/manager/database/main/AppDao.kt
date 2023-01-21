package com.ashtray.card.game.manager.database.main

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ashtray.card.game.manager.database.entities.HazariGameInfo

@Dao
interface AppDao {
    @Insert
    suspend fun insertNewHazariGame(game: HazariGameInfo)

    @Query("SELECT * FROM hazari_game_info")
    fun getAllTheHazariGame(): List<HazariGameInfo>
}