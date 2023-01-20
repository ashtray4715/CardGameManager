package com.ashtray.card.game.manager.database.main

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ashtray.card.game.manager.database.entities.HazariGameInfo

@Database(entities = [HazariGameInfo::class], version = 1, exportSchema = false)
abstract class AppDB : RoomDatabase() {

    companion object {
        @Volatile
        private var instance: AppDB? = null
        private const val DATABASE_NAME = "card_game_db"

        fun getInstance(context: Context): AppDB {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDB {
            return Room.databaseBuilder(context, AppDB::class.java, DATABASE_NAME).build()
        }
    }

    abstract fun appDao(): AppDao
}