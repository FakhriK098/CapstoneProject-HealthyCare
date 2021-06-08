package com.example.capstoneprojecthealthycare.service

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GejalaResponse {
    @SerializedName("disease")
    @Expose
    var hasil : String? = null
}