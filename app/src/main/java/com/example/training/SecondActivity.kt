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
    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "2onStop")

    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "2onStart")

    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "2onPause")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "2onDestroy")

    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Lifecycle", "2onRestart")

    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "2onResume")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Lifecycle", "2onCreate")
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