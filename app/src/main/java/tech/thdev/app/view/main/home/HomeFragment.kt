package tech.thdev.app.view.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import tech.thdev.app.data.source.image.ImageRepository
import tech.thdev.app.databinding.FragmentHomeBinding
import tech.thdev.app.view.main.home.presenter.HomeContract
import tech.thdev.app.view.main.home.presenter.HomePresenter

/**
 * Created by record-tae on 10/21/17.
 */
class HomeFragment : Fragment(), HomeContract.View {

    private val homePresenter: HomePresenter by lazy {
        HomePresenter(this@HomeFragment, ImageRepository)
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
    }

    // 코드 최신화로 context -> requireContext() 변경
    override fun showImage(imageName: String) {
        fragmentHomeBinding.imageView.setImageResource(
            resources.getIdentifier(
                imageName,
                "drawable",
                requireContext().packageName
            )
        )
    }

    override fun hideProgress() {
        fragmentHomeBinding.progressBar.visibility = View.GONE
    }

    override fun showProgress() {
        fragmentHomeBinding.progressBar.visibility = View.VISIBLE
    }
}