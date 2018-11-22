package com.artto.wallpapers.features.main.recycler

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class MainRecyclerItemDecorator(private val itemSpacing: Int, private val columnsCount: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
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