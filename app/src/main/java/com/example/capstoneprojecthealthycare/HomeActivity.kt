package com.example.capstoneprojecthealthycare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import com.example.capstoneprojecthealthycare.data.RumahSakit
import com.example.capstoneprojecthealthycare.databinding.ActivityMainBinding
import com.example.capstoneprojecthealthycare.diagnosa.DiagnosaActivity
import com.example.capstoneprojecthealthycare.info.InfoActivity
import com.example.capstoneprojecthealthycare.penyakit.PenyakitActivity
import com.example.capstoneprojecthealthycare.rumahsakit.RumahSakitActivity

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cvDiagnosa.setOnClickListener(this)
        binding.cvRumahSakit.setOnClickListener(this)
        binding.cvPenyakit.setOnClickListener(this)
        binding.cvInfo.setOnClickListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.cv_diagnosa -> {
                val intent = Intent(this, DiagnosaActivity::class.java)
                startActivity(intent)
            }
            R.id.cv_rumahSakit -> {
                val intent = Intent(this, RumahSakitActivity::class.java)
                startActivity(intent)
            }
            R.id.cv_penyakit -> {
                val intent = Intent(this, PenyakitActivity::class.java)
                startActivity(intent)
            }
            R.id.cv_info -> {
                val intent = Intent(this, InfoActivity::class.java)
                startActivity(intent)
            }
        }
    }
}