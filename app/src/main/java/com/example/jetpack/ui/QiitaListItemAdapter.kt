package com.example.jetpack.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack.databinding.QiitaListItemBinding
import com.example.jetpack.repository.model.QiitaItem


class QiitaListItemAdapter(private val items: List<QiitaItem>) :
    RecyclerView.Adapter<QiitaListItemAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = QiitaListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        Log.d("ushi_", items.size.toString())
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.binding.item = item
    }

    inner class ItemViewHolder(val binding: QiitaListItemBinding) : RecyclerView.ViewHolder(binding.root)
}