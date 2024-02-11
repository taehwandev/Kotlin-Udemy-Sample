package tech.thdev.kotlin_udemy_sample.view.detail_photo_id

import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.base.ui.BasePresenterActivity
import tech.thdev.kotlin_udemy_sample.constant.Constant
import tech.thdev.kotlin_udemy_sample.data.FlickrPhoto
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource
import tech.thdev.kotlin_udemy_sample.databinding.ActivityDetailPhotoIdBinding
import tech.thdev.kotlin_udemy_sample.view.detail_photo_id.presenter.DetailPhotoIdContract
import tech.thdev.kotlin_udemy_sample.view.detail_photo_id.presenter.DetailPhotoIdPresenter

class DetailPhotoIdActivity : BasePresenterActivity<DetailPhotoIdContract.View, DetailPhotoIdContract.Presenter>(), DetailPhotoIdContract.View {

    private lateinit var activityDetailPhotoIdBinding: ActivityDetailPhotoIdBinding

    override fun onCreatePresenter() = DetailPhotoIdPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailPhotoIdBinding = ActivityDetailPhotoIdBinding.inflate(layoutInflater)
        setContentView(activityDetailPhotoIdBinding.root)

        presenter.photoDataSource = PhotoDataSource

        setSupportActionBar(activityDetailPhotoIdBinding.toolbar)
        title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // TODO getString extra 정의
        val photoId = intent.getStringExtra(Constant.KEY_PHOTO_DATA) ?: ""
        presenter?.loadPhotoInfo(photoId)
    }

    override fun updateItem(photo: FlickrPhoto) {
        Glide.with(this)
                .load(photo.getImageUrl())
                .fitCenter()
                .into(activityDetailPhotoIdBinding.imgView)

        title = photo.title.toString()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
