package com.example.training.ui.composables.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.room.ColumnInfo
import com.example.training.database.VideoEntity
import com.example.training.vm.VideoViewModel

@Composable
fun SavedVideoCard(savedVideo: VideoEntity) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Title: ${savedVideo.title}")
        Text(text="Views: ${savedVideo.views}")
        Text(text="Author: ${savedVideo.author}")
        Text(text="Description: ${savedVideo.description}")
    }
    Spacer(modifier = Modifier.height((16.dp)))
}