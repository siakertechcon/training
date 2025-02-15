package com.example.training.ui.composables.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.training.ui.composables.components.SavedVideoCard
import com.example.training.vm.VideoViewModel

@Composable
fun SavedVideosScreen(navigateUp: () -> Boolean) {
    val viewModel: VideoViewModel = hiltViewModel<VideoViewModel>()
    viewModel.findAll()
    val savedVideos = viewModel.savedVideos.collectAsState()
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Button(onClick={navigateUp()}) {
            Text(text="Back")
        }
        LazyColumn {
            items(savedVideos.value) { savedVideo ->
                SavedVideoCard(savedVideo)
            }
        }
    }
}