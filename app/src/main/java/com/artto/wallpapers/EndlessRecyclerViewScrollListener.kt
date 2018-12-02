package com.artto.wallpapers

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView

class EndlessRecyclerViewScrollListener(private val layoutManager: GridLayoutManager, private val onLoadMoreListener: OnLoadMoreListener) : RecyclerView.OnScrollListener() {

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        if (dy > 0) {
            val firsVisible = layoutManager.findFirstVisibleItemPosition()
            val visibleCount = layoutManager.childCount
            val totalCount = layoutManager.itemCount

            if (firsVisible >= 0 && visibleCount + firsVisible >= totalCount)
                onLoadMoreListener.onLoadMore()
        }
    }
}