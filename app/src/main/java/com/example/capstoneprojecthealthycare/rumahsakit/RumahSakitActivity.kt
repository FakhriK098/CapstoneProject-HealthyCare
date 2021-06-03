package com.example.capstoneprojecthealthycare.rumahsakit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.capstoneprojecthealthycare.R
import com.example.capstoneprojecthealthycare.data.RumahSakit
import com.example.capstoneprojecthealthycare.databinding.ActivityRumahSakitBinding
import com.example.capstoneprojecthealthycare.rumahsakit.detail.DetailRumahSakitActivity

class RumahSakitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRumahSakitBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRumahSakitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.pbRumahsakit.visibility = View.INVISIBLE
        this.title = resources.getString(R.string.rumah_sakit)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[RumahSakitViewModel::class.java]
        val rumahSakit = viewModel.getRumahSakit()
        binding.pbRumahsakit.visibility = View.VISIBLE
        showData(rumahSakit)
        binding.pbRumahsakit.visibility = View.INVISIBLE
    }

    private fun showData(rumahSakit: List<RumahSakit>) {
        val adapterR = RumahSakitAdapter()
        adapterR.setCourse(rumahSakit)
        with(binding.rvRumahSakit){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = adapterR
        }

        adapterR.setOnItemClickCallback(object : RumahSakitAdapter.OnItemClickCallback {
            override fun onItemClicked(rumahSakit: RumahSakit) {
                val rumah =RumahSakit(
                    rumahSakit.nama,
                    rumahSakit.lat,
                    rumahSakit.long,
                    rumahSakit.img
                )

                val intent = Intent(this@RumahSakitActivity, DetailRumahSakitActivity::class.java)
                intent.putExtra(DetailRumahSakitActivity.EXTRA_RUMAHSAKIT, rumah)
                startActivity(intent)
            }

        })
    }

}