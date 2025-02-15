package com.example.training.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

//TODO: Update naming and fix queries
@Dao
interface VideoDao {
    @Query("SELECT * FROM videoEntity")
    fun getAll(): List<VideoEntity>

    @Query("SELECT * FROM videoEntity WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<VideoEntity>

    @Query("SELECT * FROM videoEntity WHERE title LIKE :title LIMIT 1")
    fun findByTitle(title: String): VideoEntity

    @Insert
    fun insertAll(vararg videos: VideoEntity)

    @Delete
    fun delete(video: VideoEntity)
}