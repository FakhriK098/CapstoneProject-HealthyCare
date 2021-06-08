package com.example.capstoneprojecthealthycare.diagnosa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.capstoneprojecthealthycare.R
import com.example.capstoneprojecthealthycare.data.Penyakit
import com.example.capstoneprojecthealthycare.databinding.ActivityDiagnosaBinding
import com.example.capstoneprojecthealthycare.service.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class DiagnosaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiagnosaBinding
    private val index_gejala = IntArray(133)
    private val list_gejala = ArrayList<Penyakit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiagnosaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val gejala = resources.getStringArray(R.array.Gejala)
        for (i in index_gejala.indices){
            index_gejala.set(i,0)
        }

        this.title = resources.getString(R.string.diagnosa)
        binding.pbGejala.visibility = View.INVISIBLE
        val adapterGejala = ArrayAdapter(this, android.R.layout.simple_spinner_item, gejala)
        binding.spDiagnosa.adapter = adapterGejala
        binding.spDiagnosa.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val penyakit = Penyakit(
                    gejala[p2])
                list_gejala.add(penyakit)
                showGejala()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        binding.btSubmitPenyakit.setOnClickListener {
            binding.pbGejala.visibility = View.VISIBLE
            submitGelaja(list_gejala, gejala)
        }

    }

    private fun submitGelaja(listGejala: ArrayList<Penyakit>, gejalaPenyakit: Array<String>) {
        for (i in listGejala.indices){
            for (j in gejalaPenyakit.indices){
                if (gejalaPenyakit[j].equals(listGejala[i].gejala)){
                    index_gejala.set(j,1)
                }
            }
        }
        val gejala = index_gejala.toList()
        var gejala_penyakit = Gejala()
        gejala_penyakit.symptoms = gejala
        val retro = Retro().getRetroClientInstance().create(PostServices::class.java)
        retro.addGejala(gejala_penyakit).enqueue(object : retrofit2.Callback<GejalaResponse> {
            override fun onResponse(call: Call<GejalaResponse>, response: Response<GejalaResponse>) {
                val hasil = response.body()
                Log.d("Berhasil", hasil?.hasil.toString())
                binding.pbGejala.visibility = View.INVISIBLE
            }

            override fun onFailure(call: Call<GejalaResponse>, t: Throwable) {
                Log.e("Failed",t.message.toString())
                binding.pbGejala.visibility = View.INVISIBLE
            }

        })

    }

    private fun showGejala(){
        binding.rvGejala.layoutManager = LinearLayoutManager(this)
        val gejalaAdapter = DiagnosaAdapter(list_gejala)
        binding.rvGejala.adapter = gejalaAdapter


        gejalaAdapter.setOnItemClickCallback(object : DiagnosaAdapter.OnItemClickCallback {
            override fun onItemClicked(penyakit: Penyakit) {
                list_gejala.remove(penyakit)
                showGejala()
            }
        })
    }


}