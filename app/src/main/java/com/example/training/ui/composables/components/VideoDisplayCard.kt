package com.example.training.ui.composables.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun VideoDetailsCard(
    title: String,
    duration: String,
    author: String,
    thumbnailUrl: String
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        AsyncImage(model=thumbnailUrl, contentDescription = null)
        Text(text="Title: $title")
        Text(text="Duration: $duration")
        Text(text="Author: $author")
        Spacer(
            modifier = Modifier.height(16.dp)
        )
    }
}