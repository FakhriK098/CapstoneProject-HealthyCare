package com.example.capstoneprojecthealthycare.rumahsakit.detail

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.capstoneprojecthealthycare.R
import com.example.capstoneprojecthealthycare.data.RumahSakit
import com.example.capstoneprojecthealthycare.databinding.ActivityDetailRumahSakitBinding

class DetailRumahSakitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailRumahSakitBinding

    companion object{
        const val EXTRA_RUMAHSAKIT = "rumah sakit"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailRumahSakitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rumahSakit = intent.getParcelableExtra<RumahSakit>(EXTRA_RUMAHSAKIT)
        binding.tvRumahSakit.text = rumahSakit?.nama
        Glide.with(this)
            .load(rumahSakit?.img)
            .into(binding.imgRumahSakit)

        binding.btRute.setOnClickListener {
            moveGoogleMaps(rumahSakit?.lat, rumahSakit?.long)
        }

    }

    private fun moveGoogleMaps(lat: Double?, long: Double?) {
        val startlat = resources.getString(R.string.start_Lat)
        val startlong = resources.getString(R.string.start_Long)
        val IntentUriUri = Uri.parse("http://maps.google.com/maps?saddr="+startlat+","+startlong+"&daddr="+lat+","+long)
        val mapIntent = Intent(Intent.ACTION_VIEW, IntentUriUri)
        startActivity(mapIntent)
    }
}