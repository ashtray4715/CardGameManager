package com.ashtray.card.game.manager.features.common

import com.ashtray.card.game.manager.database.entities.HazariGameInfo
import com.ashtray.card.game.manager.database.main.AppDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyRepository @Inject constructor(private val appDao: AppDao) {
    suspend fun insertNewHazariGame(game: HazariGameInfo) {
        appDao.insertNewHazariGame(game)
    }
}