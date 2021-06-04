package com.example.capstoneprojecthealthycare.service

import com.google.gson.annotations.SerializedName

data class Gejala(
    @SerializedName("symptoms") val symptoms: List<Int>
)
