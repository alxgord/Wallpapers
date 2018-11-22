package com.artto.wallpapers.features.main.recycler

import android.support.v7.widget.RecyclerView
import android.view.View
import com.artto.wallpapers.utils.pxToDp
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_wallpaper.view.*

class MainWallpaperViewHolder(
    itemView: View,
    private val itemPresenter: MainRecyclerAdapterContract.ItemPresenter,
    width: Int,
    height: Int
) :
    RecyclerView.ViewHolder(itemView),
    MainRecyclerAdapterContract.ItemView {

    init {
        with(itemView) {
            setOnClickListener { itemPresenter.onClicked(adapterPosition) }
            image_view_item_wallpaper.layoutParams.width = width
            image_view_item_wallpaper.layoutParams.height = height
        }
    }

    override fun setImage(url: String) {
        Glide.with(itemView)
            .load(url)
            .into(itemView.image_view_item_wallpaper)
    }
}