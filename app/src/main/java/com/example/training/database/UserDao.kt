package com.example.training.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

//TODO: Update naming and fix queries
@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<VideoEntity>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<VideoEntity>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): VideoEntity

    @Insert
    fun insertAll(vararg users: VideoEntity)

    @Delete
    fun delete(user: VideoEntity)
}