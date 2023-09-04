package com.rp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rp.data.local.dao.MovieDao
import com.rp.data.local.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class MovieLocalDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}
