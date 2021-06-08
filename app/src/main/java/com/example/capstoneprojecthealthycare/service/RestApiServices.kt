package com.example.capstoneprojecthealthycare.service

import android.util.Log
import retrofit2.Call
import retrofit2.Response
import java.lang.Exception


class RestApiServices {
//    fun addGejala(gejala: List<Int>, onResult: (Gejala?) -> Unit){
//        Log.d("gejala", gejala.toString())
//        val retrofit = ServiceBuilder.buildService(PostServices::class.java)
//        try {
//            retrofit.addGejala(gejala).enqueue(
//                object : retrofit2.Callback<Gejala>{
//                    override fun onResponse(call: Call<Gejala>, response: Response<Gejala>) {
//                        val gejala = response.body()
//                        Log.d("berhasil", gejala.toString())
//                        onResult(gejala)
//                    }
//
//                    override fun onFailure(call: Call<Gejala>, t: Throwable) {
//                        onResult(null)
//                    }
//
//                }
//            )
//        }catch (e : Exception){
//            Log.e("error", e.message.toString())
//        }
//    }
}