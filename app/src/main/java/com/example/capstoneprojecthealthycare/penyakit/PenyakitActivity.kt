package com.example.capstoneprojecthealthycare.penyakit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.capstoneprojecthealthycare.R
import com.example.capstoneprojecthealthycare.data.Penyakit
import com.example.capstoneprojecthealthycare.databinding.ActivityPenyakitBinding
import java.util.ArrayList

class PenyakitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPenyakitBinding
    private val list_penyakit = ArrayList<Penyakit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPenyakitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.pbPenyakit.visibility = View.INVISIBLE
        this.title = resources.getString(R.string.penyakit)

        val penyakit = resources.getStringArray(R.array.penyakit_all)
        showPenyakit(penyakit)
    }

    private fun showPenyakit(penyakit: Array<String>) {
        binding.pbPenyakit.visibility = View.VISIBLE
        for (p in penyakit){
            val penyakitL = Penyakit(p)
            list_penyakit.add(penyakitL)
        }
        binding.rvPenyakit.layoutManager = LinearLayoutManager(this)
        val penyakitAdapter = PenyakitAdapter(list_penyakit)
        binding.rvPenyakit.adapter = penyakitAdapter
        binding.pbPenyakit.visibility = View.INVISIBLE

        penyakitAdapter.setOnItemClickCallback(object : PenyakitAdapter.OnItemClickCallback {
            override fun onItemClicked(penyakit: Penyakit) {
                TODO("Not yet implemented")
            }

        })
    }
}