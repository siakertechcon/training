package com.example.training.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.example.training.ThirdActivity


fun Intent.openPhoneCall(phoneNumber: String, context: Context){
    val uri = Uri.parse("tel:+$phoneNumber")
    try {
        context.startActivity(Intent(Intent.ACTION_DIAL, uri))
    } catch (e: Exception) {
        Toast.makeText(context, "Failed to open phone app", Toast.LENGTH_LONG)
            .show()
    }
}

fun Intent.shareViaEmail(subject: String?, body: String?, context: Context){
    val uri = Uri.parse("mailto:")
    val intent = Intent(Intent.ACTION_SENDTO, uri).apply {
        putExtra(Intent.EXTRA_SUBJECT, subject.nullToEmpty())
        putExtra(Intent.EXTRA_TEXT, body.nullToEmpty())
    }
    try {
        context.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(context, "Failed to open Email app", Toast.LENGTH_LONG)
            .show()
    }
}

fun Intent.shareViaSms(message: String?, context: Context) {
    val uri = Uri.parse("smsto:")
    val intent = Intent(Intent.ACTION_SENDTO, uri).apply {
        putExtra("sms_body", message.nullToEmpty())
    }
    try {
        context.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(context, "Failed to open messaging app", Toast.LENGTH_LONG)
            .show()
    }
}

fun Intent.passDataTo3(input: String, context: Context){
    val intent = Intent(context, ThirdActivity::class.java).apply {
        putExtra("input", input)
    }
    try{
        context.startActivity(intent)
    } catch (e: ActivityNotFoundException){
        Toast.makeText(context, "Failed to find activity", Toast.LENGTH_LONG)
            .show()
    }
}