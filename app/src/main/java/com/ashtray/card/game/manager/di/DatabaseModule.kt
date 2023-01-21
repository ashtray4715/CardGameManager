package com.ashtray.card.game.manager.di

import android.content.Context
import androidx.room.Room
import com.ashtray.card.game.manager.database.main.AppDB
import com.ashtray.card.game.manager.database.main.AppDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideAppDB(@ApplicationContext context: Context): AppDB {
        return Room.databaseBuilder(context, AppDB::class.java, AppDB.DATABASE_NAME).build()
    }

    @Provides
    fun provideAppDao(appDatabase: AppDB): AppDao {
        return appDatabase.appDao()
    }
}