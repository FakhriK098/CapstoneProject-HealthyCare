package com.example.capstoneprojecthealthycare.info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.capstoneprojecthealthycare.R
import com.example.capstoneprojecthealthycare.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}