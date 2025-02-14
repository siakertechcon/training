package com.example.training

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.training.ui.theme.TrainingTheme
import com.example.training.vm.VideoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //TODO: Fill out
            val viewModel = hiltViewModel<VideoViewModel>()
            TrainingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var firstName by remember { mutableStateOf("") }
                    var lastName by remember { mutableStateOf("") }
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        TextField(value = firstName, onValueChange = {firstName = it})
                        TextField(value = lastName, onValueChange = {lastName = it})
                        Button(onClick = {viewModel.saveUser(firstName,lastName)}) {
                            Text("Save User")
                        }
                    }
                }
            }
        }
    }
}

