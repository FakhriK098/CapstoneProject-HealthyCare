package com.example.capstoneprojecthealthycare.service

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Retro {
    fun getRetroClientInstance(url: String): Retrofit{
        val gson = GsonBuilder().setLenient().create()
        val client = OkHttpClient.Builder().connectTimeout(20,TimeUnit.SECONDS)
            .writeTimeout(20,TimeUnit.SECONDS).readTimeout(20,TimeUnit.SECONDS).build()
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }
}