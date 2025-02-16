package com.example.training.vm

import android.util.Log
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.example.common_challenge.api.Result
import com.example.common_challenge.api.VideoDetails
import com.example.common_challenge.api.VideoRepo
import com.example.training.database.VideoDatabase
import com.example.training.database.VideoEntity
//import com.example.training.database.UserDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.internal.ESCAPE_STRINGS
import javax.inject.Inject


data class VideoViewModelState(
    var result: Result<List<VideoDetails>>,
    var savedVideos: List<VideoEntity>
)

@HiltViewModel
class VideoViewModel @Inject constructor(
    private val db: VideoDatabase,
    private val videoRepo: VideoRepo
) : ViewModel() {
    //TODO: Fill out more
    private val videoDao = db.videoDao()
    private val _uiState = MutableStateFlow(VideoViewModelState(
        Result.Loading<List<VideoDetails>>(),
        listOf<VideoEntity>()
    ))
    val uiState = _uiState.asStateFlow()
    init { loadVideos() }
    private fun loadVideos() {
        viewModelScope.launch(Dispatchers.IO) {
            videoRepo.getVideoDetails()
                .collect { latest ->
                    Log.d("VVM", latest.toString())
//                    _uiState.value.result = latest
                    _uiState.update { currentState ->
                        currentState.copy(result = latest)
                    }
                }
        }
    }
    fun saveVideo(videoDetails: VideoDetails) {
        val videoEntity = VideoEntity(
            videoDetails.id,
            videoDetails.title,
            videoDetails.views,
            videoDetails.author,
            videoDetails.description,
        )
        viewModelScope.launch(Dispatchers.IO) {
            if(videoDao.findById(videoDetails.id) == null) {
                videoDao.insertAll(videoEntity)
            }
        }
    }
    fun findAll() {
        viewModelScope.launch(Dispatchers.IO) {
            val videoEntities = videoDao.getAll()
            _uiState.update { currentState ->
                currentState.copy(savedVideos = videoEntities)
            }
        }
    }
}