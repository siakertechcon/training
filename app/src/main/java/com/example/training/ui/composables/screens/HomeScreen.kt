package com.example.training.ui.composables.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.Modifier.Companion.then
import androidx.compose.ui.platform.LocalGraphicsContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.training.ui.composables.components.VideoDetailsCard
import com.example.training.vm.VideoViewModel
import javax.inject.Inject

@Composable
fun HomeScreen(navigate: (String) -> Unit) {
    val viewModel: VideoViewModel = hiltViewModel<VideoViewModel>()
    val videos = viewModel.videos.collectAsState()
    Log.d("HomeScreen", "Loading HomeScreen")
    Log.d("HomeScreen", "Loading HomeScreen")

    Column (modifier = Modifier.padding(32.dp)){
        Button(
            onClick = {
                navigate("SavedVideosScreen")
            }
        ) {
            Text(text = "Saved Videos")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(videos.value) { video ->
                Box(
                    modifier = Modifier
                        .clickable {
                            navigate("VideoDetailsScreen/${video.id}")
                        }
                ) {
                    VideoDetailsCard(
                        title = video.title,
                        duration = video.duration,
                        author = video.author,
                        thumbnailUrl = video.thumbnailUrl
                    )
                }
            }
        }
    }
}

