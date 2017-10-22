package tech.thdev.app.view.main.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*
import tech.thdev.app.R
import tech.thdev.app.data.source.image.ImageRepository
import tech.thdev.app.view.main.home.presenter.HomeContract
import tech.thdev.app.view.main.home.presenter.HomePresenter

/**
 * Created by record-tae on 10/21/17.
 */
class HomeFragment : Fragment(), HomeContract.View {

    private val homePresenter: HomePresenter by lazy {
        HomePresenter(this@HomeFragment, ImageRepository)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater?.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homePresenter.loadImage()

        recycler_view.run {
//            adapter =
            layoutManager = GridLayoutManager(this@HomeFragment.context, 3)
//            addOnScrollListener()
        }
    }

//    override fun showImage(imageName: String) {
//        imageView.setImageResource(resources.getIdentifier(imageName, "drawable", context.packageName))
//    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    private val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener() {

        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

//            val visibleItemCount = recyclerView?.childCount as Int
//            val totalItemCount = adapter?.itemCount as Int
//            var firstVisibleItem = (recyclerView.layoutManager as? GridLayoutManager)?.findFirstVisibleItemPosition()
        }
    }
}