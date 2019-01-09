package com.artto.wallpapers.utils

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LoadMoreRecyclerViewListener(
    private val layoutManager: GridLayoutManager,
    private val listener: () -> Unit
) : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        if (dy > 0) {
            val firsVisible = layoutManager.findFirstVisibleItemPosition()
            val visibleCount = layoutManager.childCount
            val totalCount = layoutManager.itemCount

            if (firsVisible >= 0 && visibleCount + firsVisible >= totalCount)
                listener.invoke()
        }
    }
}