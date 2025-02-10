package com.example.training

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.training.ui.theme.TrainingTheme

class ThirdActivity: ComponentActivity() {
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
        val intent = intent
        val data = intent.getStringExtra("input")
        Log.d("Lifecycle", "2onCreate")
        setContent {
            TrainingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(data.toString())
                        Button(onClick = { openPhoneCallButBad() }) {
                            Text("Open Activity 2")
                        }
                    }
                }
            }
        }
    }

    private fun openPhoneCallButBad(){
        //tel: 7707831700
        val number = Uri.parse("tel: 7707831700")
        val intent = Intent(Intent.ACTION_DIAL)
        startActivity(intent)
    }
}