package com.example.capstoneprojecthealthycare.diagnosa


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneprojecthealthycare.data.Penyakit
import com.example.capstoneprojecthealthycare.databinding.ItemGejalaBinding

class DiagnosaAdapter(private val listGejala : ArrayList<Penyakit>) : RecyclerView.Adapter<DiagnosaAdapter.GejalaViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(penyakit: Penyakit)
    }

    inner class GejalaViewHolder(private val binding: ItemGejalaBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(penyakit: Penyakit){
            with(binding){
                tvGejala.text = penyakit.gejala

                ivDelete.setOnClickListener { onItemClickCallback?.onItemClicked(penyakit) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GejalaViewHolder {
        val binding = ItemGejalaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GejalaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GejalaViewHolder, position: Int) {
        holder.bind(listGejala[position])
    }

    override fun getItemCount(): Int = listGejala.size


}