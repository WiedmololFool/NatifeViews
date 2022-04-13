package com.max.natifeviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.max.natifeviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val linearView = binding.linearView
        linearView.apply {
            for (i in 1..15) {
                addItem("Item $i")
            }
        }
    }
}