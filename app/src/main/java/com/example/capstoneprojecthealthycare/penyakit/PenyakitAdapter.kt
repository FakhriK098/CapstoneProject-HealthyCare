package com.example.capstoneprojecthealthycare.penyakit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneprojecthealthycare.data.Penyakit
import com.example.capstoneprojecthealthycare.databinding.ItemPenyakitBinding

class PenyakitAdapter(private val list : ArrayList<Penyakit>) : RecyclerView.Adapter<PenyakitAdapter.PenyakitViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(penyakit: Penyakit)
    }

    inner class PenyakitViewHolder(private val binding: ItemPenyakitBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(penyakit: Penyakit){
            with(binding){
                tvPenyakit.text = penyakit.gejala

                itemView.setOnClickListener { onItemClickCallback?.onItemClicked(penyakit) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PenyakitViewHolder {
        val binding = ItemPenyakitBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PenyakitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PenyakitViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}