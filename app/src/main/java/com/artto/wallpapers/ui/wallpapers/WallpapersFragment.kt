package com.artto.wallpapers.ui.wallpapers

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.artto.wallpapers.AppConstants
import com.artto.wallpapers.R
import com.artto.wallpapers.ui.adapter.wallpaper.WallpaperRecyclerAdapter
import com.artto.wallpapers.ui.adapter.wallpaper.WallpapersRecyclerItemDecorator
import com.artto.wallpapers.ui.base.BaseFragment
import com.artto.wallpapers.utils.LoadMoreRecyclerViewListener
import kotlinx.android.synthetic.main.fragment_wallpapers.*
import org.koin.android.ext.android.inject

class WallpapersFragment : BaseFragment(), WallpapersView {

    @InjectPresenter
    lateinit var presenter: WallpapersPresenter

    @ProvidePresenter
    fun providePresenter() = inject<WallpapersPresenter>().value

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val columns = AppConstants.MainRecycler.columns
        val itemWidth = (resources.displayMetrics.widthPixels / columns)
        val itemHeight = (itemWidth * AppConstants.MainRecycler.sizeMultiplier).toInt()

        with(recycler_view_main) {
            setHasFixedSize(true)
            adapter = WallpaperRecyclerAdapter(presenter, itemWidth, itemHeight)
            addItemDecoration(WallpapersRecyclerItemDecorator(8, columns))
            
            addOnScrollListener(
                LoadMoreRecyclerViewListener(
                    layoutManager as GridLayoutManager,
                    presenter::loadWallpapers
                )
            )
        }

        presenter.onCreate(arguments?.getString("categoryName"))
    }

    override fun notifyItemRangeInserted(position: Int, count: Int) {
        recycler_view_main.adapter?.notifyItemRangeInserted(position, count)
    }

    override fun navigateUp() {
        findNavController().navigateUp()
    }

    override fun getLayout() = R.layout.fragment_wallpapers

}