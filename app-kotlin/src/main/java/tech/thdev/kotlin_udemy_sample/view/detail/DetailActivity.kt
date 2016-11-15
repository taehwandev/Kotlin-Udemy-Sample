package tech.thdev.kotlin_udemy_sample.view.detail

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.text.Html
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_parcelable.*
import tech.thdev.base.view.BasePresenterActivity
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.constant.Constant
import tech.thdev.kotlin_udemy_sample.data.FlickrPhoto
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource
import tech.thdev.kotlin_udemy_sample.util.decimalFormat
import tech.thdev.kotlin_udemy_sample.util.getDate
import tech.thdev.kotlin_udemy_sample.view.detail.presenter.DetailContract
import tech.thdev.kotlin_udemy_sample.view.detail.presenter.DetailPresenter

class DetailActivity : BasePresenterActivity<DetailContract.View, DetailContract.Presenter>(), DetailContract.View {

    private var bottomSheet: BottomSheetBehavior<RelativeLayout>? = null

    override fun onCreatePresenter() = DetailPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_parcelable)

        presenter?.photoDataSource = PhotoDataSource

        setSupportActionBar(toolbar)
        title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val photoId = intent.getStringExtra(Constant.KEY_PHOTO_DATA)
        presenter?.loadPhotoInfo(photoId)

        bottomSheet = BottomSheetBehavior.from(rl_bottom_sheet)
    }

    override fun updateItem(photo: FlickrPhoto) {
        Glide.with(this)
                .load(photo.getImageUrl())
                .fitCenter()
                .crossFade()
                .into(img_view)

        tv_title.text = photo.title.toString()
        tv_content.text = Html.fromHtml(photo.description._content)
        tv_date.text = photo.dates.lastupdate.getDate("MM-dd-yyyy")
        tv_viewer_count.text = photo.views.decimalFormat()
        tv_comment_count.text = photo.comments._content.decimalFormat()

        tv_user_name.text = photo.owner.username
    }
}
