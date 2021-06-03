package com.example.capstoneprojecthealthycare

import android.view.View

class PenyakitOnItemClickListener(private val position: Int, private val onItemClickCallback : OnItemClickCallback) : View.OnClickListener {
    interface OnItemClickCallback {
        fun onItemClicked(view: View, position: Int)
    }

    override fun onClick(p0: View) {
        onItemClickCallback.onItemClicked(p0, position)
    }
}