package com.artto.wallpapers.ui.adapter.wallpaper

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class WallpapersRecyclerItemDecorator(private val itemSpacing: Int, private val columnsCount: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, p: RecyclerView.State) {
        val position = parent.getChildLayoutPosition(view) + 1
        val spacing = itemSpacing / 2

        with(outRect) {
            bottom = itemSpacing
            when (position % columnsCount) {
                1 -> right = spacing
                0 -> left = spacing
                else -> {
                    left = spacing
                    right = spacing
                }
            }
        }
    }
}