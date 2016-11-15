package tech.thdev.kotlin_udemy_sample.view.detail

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_parcelable.*
import kotlinx.android.synthetic.main.bottom_sheet_detail_view.*
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

    private var mBottomSheet: BottomSheetBehavior<RelativeLayout>? = null

    private var isShowInfoIcon = false

    private val rl_sheet_view by lazy {
        findViewById(R.id.rl_sheet_view) as RelativeLayout
    }

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

        mBottomSheet = BottomSheetBehavior.from(rl_sheet_view)
        mBottomSheet?.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                if (slideOffset > 0.9) {
                    rl_toolbar_user_info.visibility = View.GONE
                    rl_toolbar_image_info.visibility = View.VISIBLE
                    tv_title.visibility = View.INVISIBLE
                    isShowInfoIcon = true
                    invalidateOptionsMenu()
                } else {
                    rl_toolbar_user_info.visibility = View.VISIBLE
                    rl_toolbar_image_info.visibility = View.GONE
                    tv_title.visibility = View.VISIBLE

                    isShowInfoIcon = false
                    invalidateOptionsMenu()
                }
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
            }
        })

        fab.setOnClickListener {
            presenter?.shareUrl(Constant.TYPE_DETAIL_PAGE)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menu?.findItem(R.id.action_info)?.isVisible = isShowInfoIcon
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_share -> {
                presenter?.shareUrl(Constant.TYPE_SHARE_URL)
            }
            R.id.action_info -> {
                presenter?.shareUrl(Constant.TYPE_DETAIL_PAGE)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showShareUrl(photoPageUrl: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_TEXT, photoPageUrl)
        intent.type = "text/plain"
        startActivity(Intent.createChooser(intent, "Share"))
    }

    override fun showDetailPage(photoPageUrl: String) {
        // TODO Chrome page change...
    }

    override fun updateToolbarItem(buddyIcon: String, buddyName: String, imgUrl: String, imgTitle: String) {
        rl_toolbar_user_info.visibility = View.VISIBLE
        rl_toolbar_image_info.visibility = View.GONE

        // Buddy icon
        Glide.with(this)
                .load(buddyIcon)
                .centerCrop()
                .crossFade()
                .into(img_buddy_icon)

        tv_buddy_name.text = buddyName

        // small image
        Glide.with(this)
                .load(imgUrl)
                .centerCrop()
                .crossFade()
                .into(img_small)
        tv_toolbar_title.text = imgTitle
    }

    override fun updateItem(photo: FlickrPhoto) {
        Glide.with(this)
                .load(photo.getImageUrl())
                .fitCenter()
                .crossFade()
                .into(img_view)

        mBottomSheet?.state = BottomSheetBehavior.STATE_COLLAPSED
        tv_title.text = photo.title.toString()
        tv_content.text = Html.fromHtml(photo.description._content)
        tv_date.text = photo.dates.lastupdate.getDate("MM-dd-yyyy")
        tv_viewer_count.text = photo.views.decimalFormat()
        tv_comment_count.text = photo.comments._content.decimalFormat()
    }
}
