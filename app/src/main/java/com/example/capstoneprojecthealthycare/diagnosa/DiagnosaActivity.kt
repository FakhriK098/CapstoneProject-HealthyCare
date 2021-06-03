package com.example.capstoneprojecthealthycare.diagnosa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.capstoneprojecthealthycare.R
import com.example.capstoneprojecthealthycare.data.Penyakit
import com.example.capstoneprojecthealthycare.databinding.ActivityDiagnosaBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.RequestParams
import cz.msebera.android.httpclient.Header
import java.io.OutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLConnection

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
            submitGelaja(list_gejala, gejala)
        }

    }

    private fun submitGelaja(listGejala: ArrayList<Penyakit>, gejalaPenyakit: Array<String>) {
        for (i in listGejala.indices){
            for (j in gejalaPenyakit.indices){
                if (gejalaPenyakit[i].equals(listGejala[i].gejala)){
                    index_gejala.set(j,1)
                }
            }
        }
//        val cloud : URL = URL(resources.getString(R.string.URL))
//        val con : URLConnection = cloud.openConnection()
//        val http : HttpURLConnection = con as HttpURLConnection
//        http.requestMethod = "POST"
//        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8")
//        http.setRequestProperty("Accept", "application/json")
//        http.doOutput = true
//
//        val out : String = "{\"symptoms\""+index_gejala+"\"}"
//        try {
//            val os : OutputStream = con.outputStream
//            val input : ByteArray = out.toByteArray()
//            os.write(input, 0, input.size)
//        }catch ()
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