package com.example.capstoneprojecthealthycare.rumahsakit

import android.location.Location
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.capstoneprojecthealthycare.R
import com.example.capstoneprojecthealthycare.data.Penyakit
import com.example.capstoneprojecthealthycare.data.RumahSakit
import com.example.capstoneprojecthealthycare.databinding.ItemRumahSakitBinding
import java.util.ArrayList

class RumahSakitAdapter() : RecyclerView.Adapter<RumahSakitAdapter.RumahSakitViewHolder>() {

    private val listRumahSakit = ArrayList<RumahSakit>()

    fun setCourse(course : List<RumahSakit>?){
        if (course == null)return
        this.listRumahSakit.clear()
        this.listRumahSakit.addAll(course)
    }

    private var onItemClickCallback: OnItemClickCallback? = null
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(rumahSakit: RumahSakit)
    }

    inner class RumahSakitViewHolder(private val binding : ItemRumahSakitBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(course: RumahSakit){
            with(binding){
                tvRumahSakit.text = course.nama
                val distance = distance(R.string.start_Lat.toDouble(), R.string.start_Long.toDouble(), course.lat, course.long)
                tvJarakRumahsakit.text = distance.toString()
                Glide.with(itemView.context)
                        .load(course.img)
                        .apply(RequestOptions().override(55,55))
                        .into(avatarRumahSakit)
                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(course) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RumahSakitViewHolder {
        val itemRumahSakitBinding = ItemRumahSakitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  RumahSakitViewHolder(itemRumahSakitBinding)
    }

    override fun onBindViewHolder(holder: RumahSakitViewHolder, position: Int) {
        val course = listRumahSakit[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listRumahSakit.size

    private fun distance(startLat : Double, startLong : Double, stopLat : Double, stopLong : Double): Int {
        val result = FloatArray(1)
        Location.distanceBetween(startLat,startLong,stopLat,stopLong,result)
        val distance = result[0]

        val kilometer : Int = (distance/1000).toInt()
        return kilometer
    }
}