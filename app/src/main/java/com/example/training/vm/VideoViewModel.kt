package com.example.training.vm

import androidx.lifecycle.ViewModel
import com.example.common_challenge.api.VideoRepo
import com.example.training.database.UserDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VideoViewModel @Inject constructor(
    private val db: UserDatabase,
    private val videoRepo: VideoRepo
) : ViewModel() {
    //TODO: Fill out more
    private val userDao = db.userDao()
}