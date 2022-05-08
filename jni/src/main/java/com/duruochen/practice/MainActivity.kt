package com.duruochen.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import okhttp3.OkHttpClient

class MainActivity : AppCompatActivity() {
    val version = 6

    val version1 = 4

    val version2= 1

    val revert1 = 1

    val revert2 = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val okhttp = OkHttpClient()
    }
}