package com.example.training.ui.composables.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.common_challenge.api.VideoDetails
import com.example.training.ui.composables.components.VideoDetailsCard
import com.example.training.vm.VideoViewModel

@Composable
fun VideoDetailsScreen(
        navigate: (String) -> Unit,
        navigateUp: () -> Boolean,
        videoId: Int?
) {
    val viewModel: VideoViewModel = hiltViewModel<VideoViewModel>()
    val videoDetails = viewModel.videos.collectAsState()
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Button(onClick = {navigateUp()}) {
            Text(text="Back")
        }
        if(videoId != null) {
            val videoDetail = videoDetails.value.find { video -> video.id == videoId }
            if(videoDetail != null) {
                VideoDetailsCard(videoDetail)
            }
        }
    }
}