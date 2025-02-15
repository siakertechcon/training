package com.example.training.ui.composables.components

import androidx.compose.foundation.border
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.example.common_challenge.api.VideoDetails
import com.example.training.vm.VideoViewModel

@Composable
fun VideoDetailsCard(videoDetails: VideoDetails) {
    val viewModel: VideoViewModel = hiltViewModel<VideoViewModel>()
    Column(
        modifier = Modifier
            .padding(
                horizontal = 16.dp,
                vertical = 16.dp
            )
    ) {
        AsyncImage(model="${videoDetails.thumbnailUrl}", contentDescription = null)
        Text(text="Title: ${videoDetails.title}")
        Text(text="Duration: ${videoDetails.duration}")
        Text(text="Upload Time: ${videoDetails.uploadTime}")
        Text(text="Views: ${videoDetails.views}")
        Text(text="Author: ${videoDetails.author}")
        Text(text="Video Url: ${videoDetails.videoUrl}")
        Text(text="Description: ${videoDetails.description}")
        Text(text="Subscriber: ${videoDetails.subscriber}")
        Text(text="Live Now: ${videoDetails.isLive}")
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                viewModel.saveVideo(videoDetails)
            }
        ) {
            Text(text="Save Video")
        }
    }
}
