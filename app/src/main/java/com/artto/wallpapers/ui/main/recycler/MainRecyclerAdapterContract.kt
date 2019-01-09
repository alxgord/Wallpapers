package com.artto.wallpapers.ui.main.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artto.wallpapers.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_wallpaper.view.*


class MainRecyclerAdapter(
    private val adapterPresenter: AdapterPresenter,
    private val itemWidth: Int,
    private val itemHeight: Int
) :
    RecyclerView.Adapter<MainWallpaperViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MainWallpaperViewHolder =
        MainWallpaperViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_wallpaper, parent, false),
            itemWidth,
            itemHeight
        )

    override fun getItemCount(): Int = adapterPresenter.getItemCount()

    override fun onBindViewHolder(viewHolder: MainWallpaperViewHolder, position: Int) =
        adapterPresenter.onBindViewHolder(viewHolder, position)
}


class MainWallpaperViewHolder(itemView: View, width: Int, height: Int) : RecyclerView.ViewHolder(itemView), ItemView {

    init {
        with(itemView) {
            image_view_item_wallpaper.layoutParams.width = width
            image_view_item_wallpaper.layoutParams.height = height
        }
    }

    override fun setData(url: String, listener: (Int) -> Unit) {
        with(itemView) {
            Glide.with(this)
                .load(url)
                .into(image_view_item_wallpaper)

            setOnClickListener { listener.invoke(adapterPosition) }
        }
    }
}


interface AdapterPresenter {
    fun getItemCount(): Int
    fun onBindViewHolder(view: ItemView, position: Int)
}


interface ItemView {
    fun setData(url: String, listener: (Int) -> Unit)
}
