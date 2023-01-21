package com.ashtray.card.game.manager.database.main

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ashtray.card.game.manager.database.entities.HazariGameInfo

@Database(entities = [HazariGameInfo::class], version = 1, exportSchema = false)
abstract class AppDB : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "card_game_db"
    }

    abstract fun appDao(): AppDao
}