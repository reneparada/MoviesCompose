package com.rp.data.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rp.data.BuildConfig.DATABASE_NAME
import com.rp.data.local.MovieLocalDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): RoomDatabase =
        Room.databaseBuilder(context = context, MovieLocalDatabase::class.java, DATABASE_NAME)
            .build()

    @Provides
    @Singleton
    fun provideMovieDao(database: MovieLocalDatabase) = database.movieDao()
}
