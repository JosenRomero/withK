package com.romero.withk.fragments.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.romero.withk.databinding.ItemRowBinding
import com.romero.withk.model.Item

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var itemsList = emptyList<Item>()

    // R.layout.item_row - ItemRowBinding
    class HomeViewHolder(val binding: ItemRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {

        holder.binding.apply {
            title.text = itemsList[position].author
        }

    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    fun setItems(items: List<Item>) {
        itemsList = items
        notifyDataSetChanged()
    }

}