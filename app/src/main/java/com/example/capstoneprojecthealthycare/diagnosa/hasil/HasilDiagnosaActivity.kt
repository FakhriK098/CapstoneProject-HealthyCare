package com.example.capstoneprojecthealthycare.diagnosa.hasil

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.capstoneprojecthealthycare.R
import com.example.capstoneprojecthealthycare.data.RumahSakit
import com.example.capstoneprojecthealthycare.databinding.ActivityHasilDiagnosaBinding
import com.example.capstoneprojecthealthycare.rumahsakit.RumahSakitAdapter
import com.example.capstoneprojecthealthycare.rumahsakit.RumahSakitViewModel
import com.example.capstoneprojecthealthycare.rumahsakit.detail.DetailRumahSakitActivity

class HasilDiagnosaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHasilDiagnosaBinding
    companion object{
        const val EXTRA_HASIL = "hasil"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHasilDiagnosaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[RumahSakitViewModel::class.java]
        val rumahSakit = viewModel.getRumahSakit()
        showData(rumahSakit)
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

                val intent = Intent(this@HasilDiagnosaActivity, DetailRumahSakitActivity::class.java)
                intent.putExtra(DetailRumahSakitActivity.EXTRA_RUMAHSAKIT, rumah)
                startActivity(intent)
            }

        })
    }
}