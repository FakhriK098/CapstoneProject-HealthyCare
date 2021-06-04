package com.example.capstoneprojecthealthycare.service

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface PostServices {

    @Headers("Content-Type: application/json")
    @POST("symptoms")
    fun addGejala(@Body gejala: List<Int>) : Call<Gejala>
}