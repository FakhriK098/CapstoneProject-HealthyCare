package com.example.capstoneprojecthealthycare.service

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Gejala{
    @SerializedName("symptoms")
    @Expose
    var symptoms : List<Int> = emptyList()
}