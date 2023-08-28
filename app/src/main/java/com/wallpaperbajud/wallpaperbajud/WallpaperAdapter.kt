package com.wallpaperbajud.wallpaperbajud

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallpaperbajud.databinding.WallpaperItemBinding

class WallpaperAdapter: RecyclerView.Adapter<WallpaperAdapter.WallpaperHolder>() {

    var photos = ArrayList<PhotosItem>()
    lateinit var context: Context

    class WallpaperHolder(itemView: WallpaperItemBinding) : RecyclerView.ViewHolder(itemView.root){
        var binding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallpaperHolder {
        context = parent.context
        var binding = WallpaperItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return WallpaperHolder(binding)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: WallpaperHolder, position: Int) {

        holder.binding.apply {

            photos.get(position)?.src?.apply {

                Glide.with(context).load(portrait).into(imgPhotos)

            }

        }

    }

    fun setPhotos(photos: List<PhotosItem?>?) {
        this.photos = photos as ArrayList<PhotosItem>
    }
}