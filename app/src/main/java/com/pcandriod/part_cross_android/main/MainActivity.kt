package com.pcandriod.part_cross_android.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pcandriod.part_cross_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}