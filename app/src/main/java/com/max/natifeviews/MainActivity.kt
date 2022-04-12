package com.max.natifeviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.max.natifeviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        val linearView = binding.linearView
        linearView.addItem("MyText")
    }
}