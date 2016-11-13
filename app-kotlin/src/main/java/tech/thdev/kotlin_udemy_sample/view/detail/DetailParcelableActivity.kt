package tech.thdev.kotlin_udemy_sample.view.detail

import android.os.Bundle
import tech.thdev.base.view.BasePresenterActivity
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.data.FlickrPhoto
import tech.thdev.kotlin_udemy_sample.view.detail.presenter.DetailContract
import tech.thdev.kotlin_udemy_sample.view.detail.presenter.DetailPresenter

class DetailParcelableActivity : BasePresenterActivity<DetailContract.View, DetailContract.Presenter>(), DetailContract.View {

    override fun onCreatePresenter() = DetailPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_parcelable)
    }

    override fun updateItem(photo: FlickrPhoto) {

    }
}
