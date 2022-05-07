package com.duruochen.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import okhttp3.OkHttpClient

class MainActivity : AppCompatActivity() {
    val version = 6

    val version1 = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val okhttp = OkHttpClient()
    }
}