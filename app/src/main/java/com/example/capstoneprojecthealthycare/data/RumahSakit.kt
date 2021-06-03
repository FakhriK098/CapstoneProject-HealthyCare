package com.example.capstoneprojecthealthycare.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RumahSakit(
    var nama: String,
    var lat: Double,
    var long: Double,
    var img: String
): Parcelable
