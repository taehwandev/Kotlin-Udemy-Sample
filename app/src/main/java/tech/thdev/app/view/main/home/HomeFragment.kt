package tech.thdev.app.view.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tech.thdev.app.data.source.image.ImageRepository
import tech.thdev.app.databinding.FragmentHomeBinding
import tech.thdev.app.view.main.home.adapter.ImageRecyclerAdapter
import tech.thdev.app.view.main.home.presenter.HomeContract
import tech.thdev.app.view.main.home.presenter.HomePresenter

/**
 * Created by record-tae on 10/21/17.
 */
class HomeFragment : Fragment(), HomeContract.View {

    private val homePresenter: HomePresenter by lazy {
        HomePresenter(this@HomeFragment, ImageRepository, imageRecyclerAdapter)
    }

    // API 최신화로 context 대신 requireContext 사용
    private val imageRecyclerAdapter: ImageRecyclerAdapter by lazy {
        ImageRecyclerAdapter()
    }

    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentHomeBinding.inflate(inflater, container, false).also {
            fragmentHomeBinding = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homePresenter.loadImage()

        fragmentHomeBinding.recyclerView.run {
            adapter = imageRecyclerAdapter
            layoutManager = GridLayoutManager(this@HomeFragment.context, 3)
            addOnScrollListener(recyclerViewOnScrollListener)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentHomeBinding.recyclerView.removeOnScrollListener(recyclerViewOnScrollListener)
    }

    override fun hideProgress() {
        fragmentHomeBinding.progressBar.visibility = View.GONE
    }

    override fun showProgress() {
        fragmentHomeBinding.progressBar.visibility = View.VISIBLE
    }

    private val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener() {

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val visibleItemCount = recyclerView.childCount
            val totalItemCount = imageRecyclerAdapter.itemCount
            val firstVisibleItem = (recyclerView.layoutManager as? GridLayoutManager)?.findFirstVisibleItemPosition() ?: 0

            if (!homePresenter.isLoading && (firstVisibleItem + visibleItemCount) >= totalItemCount - 3) {
                homePresenter.loadImage()
            }
        }
    }
}