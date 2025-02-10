package com.example.training.utils

/**
 * Used on a null string to print "" instead of "null"
 * */
fun String?.nullToEmpty(): String = this ?: ""