package com.artto.wallpapers.ui.categories

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.artto.wallpapers.AppConstants
import com.artto.wallpapers.utils.LoadMoreRecyclerViewListener
import com.artto.wallpapers.R
import com.artto.wallpapers.ui.base.BaseFragment
import com.artto.wallpapers.ui.adapter.wallpaper.WallpaperRecyclerAdapter
import com.artto.wallpapers.ui.adapter.wallpaper.WallpapersRecyclerItemDecorator
import kotlinx.android.synthetic.main.fragment_wallpapers.*
import org.koin.android.ext.android.inject

class CategoriesFragment : BaseFragment(), CategoriesView {

    @InjectPresenter
    lateinit var presenter: CategoriesPresenter

    @ProvidePresenter
    fun providePresenter() = inject<CategoriesPresenter>().value

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val columns = AppConstants.MainRecycler.columns
        val itemWidth = (resources.displayMetrics.widthPixels / columns)
        val itemHeight = (itemWidth * AppConstants.MainRecycler.sizeMultiplier).toInt()

        with(recycler_view_main) {
            setHasFixedSize(true)
            adapter = WallpaperRecyclerAdapter(presenter, itemWidth, itemHeight)
            addItemDecoration(WallpapersRecyclerItemDecorator(8, columns))
        }
    }

    override fun notifyItemRangeInserted(position: Int, count: Int) {
        recycler_view_main.adapter?.notifyItemRangeInserted(position, count)
    }

    override fun navigateToCategory(category: String) =
        findNavController().navigate(CategoriesFragmentDirections.actionMainFragmentToWallpapersListFragment(category))


    override fun getLayout() = R.layout.fragment_wallpapers

}