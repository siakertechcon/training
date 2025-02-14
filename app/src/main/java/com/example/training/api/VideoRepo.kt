package com.example.common_challenge.api

import kotlinx.coroutines.flow.Flow

interface VideoRepo {
    suspend fun getVideoDetails(): Flow<Result<List<VideoDetails>>>
}