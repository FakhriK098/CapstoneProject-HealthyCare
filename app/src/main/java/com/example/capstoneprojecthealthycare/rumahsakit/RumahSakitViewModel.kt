package com.example.capstoneprojecthealthycare.rumahsakit

import androidx.lifecycle.ViewModel
import com.example.capstoneprojecthealthycare.data.RumahSakit
import com.example.capstoneprojecthealthycare.utils.Dummy

class RumahSakitViewModel : ViewModel() {
    fun getRumahSakit() : List<RumahSakit> = Dummy.generateDummyCourses()
}