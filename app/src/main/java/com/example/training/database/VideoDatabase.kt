package com.example.training.database

import androidx.room.Database
import androidx.room.RoomDatabase

//TODO: Update naming
@Database(entities = [VideoEntity::class], version = 1)
abstract class VideoDatabase : RoomDatabase() {
    abstract fun videoDao(): VideoDao
}