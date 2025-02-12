package com.example.training

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.training.ui.theme.TrainingTheme
import com.example.training.utils.openPhoneCall


class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        val inputFromMain = intent.getStringExtra("user_input")
        setContent {
            TrainingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Button(onClick = { openPhoneCall() }) {
                        Text(inputFromMain.toString())
                    }
                }
            }
        }
    }

    private fun openPhoneCall() {
        Intent().openPhoneCall("17707831700",this)
    }
}