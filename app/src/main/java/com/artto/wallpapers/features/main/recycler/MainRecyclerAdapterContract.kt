package com.artto.wallpapers.features.main.recycler

interface MainRecyclerAdapterContract {

    interface AdapterPresenter {
        fun getItemCount(): Int
        fun onBindViewHolder(view: ItemView, position: Int)
    }

    interface ItemPresenter {
        fun onClicked(position: Int)
    }

    interface ItemView {
        fun setImage(url: String)
    }

}