package com.artto.wallpapers.ui.adapter.wallpaper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artto.wallpapers.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_wallpaper.view.*


class WallpaperRecyclerAdapter(
    private val adapterPresenter: AdapterPresenter,
    private val itemWidth: Int,
    private val itemHeight: Int
) :
    RecyclerView.Adapter<WallpaperViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): WallpaperViewHolder =
        WallpaperViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_wallpaper, parent, false),
            itemWidth,
            itemHeight
        )

    override fun getItemCount(): Int = adapterPresenter.getItemCount()

    override fun onBindViewHolder(viewHolder: WallpaperViewHolder, position: Int) =
        adapterPresenter.onBindViewHolder(viewHolder, position)
}


class WallpaperViewHolder(itemView: View, width: Int, height: Int) : RecyclerView.ViewHolder(itemView),
    ItemView {

    init {
        with(itemView) {
            iv_item_wallpaper.layoutParams.width = width
            iv_item_wallpaper.layoutParams.height = height
        }
    }

    override fun setData(url: String, caption: String?, listener: (Int) -> Unit) {
        with(itemView) {
            Glide.with(this)
                .load(url)
                .into(iv_item_wallpaper)

            tv_item_caption.visibility = if (caption != null) View.VISIBLE else View.GONE
            tv_item_caption.text = caption ?: ""

            setOnClickListener { listener.invoke(adapterPosition) }
        }
    }
}


interface AdapterPresenter {
    fun getItemCount(): Int
    fun onBindViewHolder(view: ItemView, position: Int)
}


interface ItemView {
    fun setData(url: String, caption: String? = null, listener: (Int) -> Unit)
}
