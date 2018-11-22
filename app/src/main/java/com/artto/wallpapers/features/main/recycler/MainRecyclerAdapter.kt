package com.artto.wallpapers.features.main.recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.artto.wallpapers.R

class MainRecyclerAdapter(
    private val adapterPresenter: MainRecyclerAdapterContract.AdapterPresenter,
    private val itemPresenter: MainRecyclerAdapterContract.ItemPresenter,
    private val itemWidth: Int,
    private val itemHeight: Int
) : RecyclerView.Adapter<MainWallpaperViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MainWallpaperViewHolder =
        MainWallpaperViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_wallpaper, parent, false),
            itemPresenter,
            itemWidth,
            itemHeight
        )

    override fun getItemCount(): Int = adapterPresenter.getItemCount()

    override fun onBindViewHolder(viewHolder: MainWallpaperViewHolder, position: Int) =
        adapterPresenter.onBindViewHolder(viewHolder, position)
}