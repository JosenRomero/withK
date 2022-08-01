package com.romero.withk.fragments.imagesRandom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.romero.withk.R
import com.romero.withk.databinding.ImageRowBinding
import com.romero.withk.model.Item

class ImagesAdapter: RecyclerView.Adapter<ImagesAdapter.ImagesViewHolder>() {

    private var imagesList = emptyList<Item>()

    // // R.layout.image_row - ImageRowBinding
    class ImagesViewHolder(val binding: ImageRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        val binding = ImageRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImagesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {

        holder.binding.apply {

            val secondText: String = "ID: " + imagesList[position].id.toString()

            author.text = imagesList[position].author
            numberId.text = secondText

            // img
            Glide.with(imgUrl.context)
                .load(imagesList[position].image)
                .apply(RequestOptions())
                .placeholder(R.drawable.ic_launcher_background)
                .centerCrop()
                .into(imgUrl)

        }

    }

    override fun getItemCount(): Int {
        return imagesList.size
    }

    fun setImages(images: List<Item>) {
        imagesList = images
        notifyDataSetChanged()
    }

}