package tech.thdev.kotlin_udemy_sample.view.detail

import android.os.Bundle
import android.widget.Toast
import tech.thdev.base.view.BasePresenterActivity
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.constant.Constant
import tech.thdev.kotlin_udemy_sample.data.FlickrPhoto
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource
import tech.thdev.kotlin_udemy_sample.view.detail.presenter.DetailContract
import tech.thdev.kotlin_udemy_sample.view.detail.presenter.DetailPresenter

class DetailActivity : BasePresenterActivity<DetailContract.View, DetailContract.Presenter>(), DetailContract.View {

    override fun onCreatePresenter() = DetailPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_parcelable)

        presenter?.photoDataSource = PhotoDataSource

        val photoId = intent.getStringExtra(Constant.KEY_PHOTO_DATA)
        presenter?.loadPhotoInfo(photoId)
    }

    override fun updateItem(photo: FlickrPhoto) {
        Toast.makeText(this, photo.dates.posted, Toast.LENGTH_SHORT).show()
    }
}
