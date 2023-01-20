package com.ashtray.card.game.manager.apps

import com.ashtray.card.game.manager.database.main.AppDao
import javax.inject.Inject

class MyRepository @Inject constructor(private val appDao: AppDao) {
}