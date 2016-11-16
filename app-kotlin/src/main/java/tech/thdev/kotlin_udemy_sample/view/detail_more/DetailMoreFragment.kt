package tech.thdev.kotlin_udemy_sample.view.detail_more

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.FloatingActionButton
import android.text.Html
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_detail_more.*
import tech.thdev.base.view.BasePresenterFragment
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.constant.Constant
import tech.thdev.kotlin_udemy_sample.data.FlickrPhoto
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource
import tech.thdev.kotlin_udemy_sample.util.decimalFormat
import tech.thdev.kotlin_udemy_sample.util.getDate
import tech.thdev.kotlin_udemy_sample.view.detail_more.presenter.DetailMoreContract
import tech.thdev.kotlin_udemy_sample.view.detail_more.presenter.DetailMorePresenter

/**
 * Created by Tae-hwan on 16/11/2016.
 */

class DetailMoreFragment private constructor() : BasePresenterFragment<DetailMoreContract.View, DetailMoreContract.Presenter>(), DetailMoreContract.View {

    /**
     * Info icon showing
     */
    private var isShowInfoIcon = false

    private val rlSheetView by lazy {
        activity.findViewById(R.id.rl_sheet_view) as RelativeLayout
    }

    private val bottomSheet by lazy {
        BottomSheetBehavior.from(rlSheetView)
    }

    private val rlToolbarUserInfo by lazy {
        activity.findViewById(R.id.rl_toolbar_user_info) as RelativeLayout
    }

    private val rlToolbarImageInfo by lazy {
        activity.findViewById(R.id.rl_toolbar_image_info) as RelativeLayout
    }

    private val tvBottomTitle by lazy {
        activity.findViewById(R.id.tv_title) as TextView
    }

    private val tvBottomContent by lazy {
        activity.findViewById(R.id.tv_content) as TextView
    }

    private val tvBottomDate by lazy {
        activity.findViewById(R.id.tv_date) as TextView
    }

    private val tvBottomViewerCount by lazy {
        activity.findViewById(R.id.tv_viewer_count) as TextView
    }

    private val tvBottomCommentCount by lazy {
        activity.findViewById(R.id.tv_comment_count) as TextView
    }

    private val imgToolbarBuddyIcon by lazy {
        activity.findViewById(R.id.img_buddy_icon) as ImageView
    }

    private val tvToolbarBuddyName by lazy {
        activity.findViewById(R.id.tv_buddy_name) as TextView
    }

    private val imgToolbarSmall by lazy {
        activity.findViewById(R.id.img_small) as ImageView
    }

    private val tvToolbarImageTitle by lazy {
        activity.findViewById(R.id.tv_toolbar_title) as TextView
    }

    private val fab by lazy {
        activity.findViewById(R.id.fab) as FloatingActionButton
    }

    override fun onCreatePresenter() = DetailMorePresenter()

    override fun getLayout() = R.layout.fragment_detail_more

    companion object {
        fun create(photoId: String?): DetailMoreFragment {
            val fragment = DetailMoreFragment()
            fragment.arguments = Bundle()
            Log.d("TAG", "photoId $photoId")
            fragment.arguments.putString(Constant.KEY_PHOTO_DATA, photoId)
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Option menu activate
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter?.photoDataSource = PhotoDataSource

        bottomSheet.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                if (slideOffset > 0.9) {
                    rlToolbarUserInfo.visibility = View.GONE
                    rlToolbarImageInfo.visibility = View.VISIBLE
                    tvBottomTitle.visibility = View.INVISIBLE

                    isShowInfoIcon = true

                } else {
                    rlToolbarUserInfo.visibility = View.VISIBLE
                    rlToolbarImageInfo.visibility = View.GONE
                    tvBottomTitle.visibility = View.VISIBLE

                    isShowInfoIcon = false
                }
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    activity.onBackPressed()
                }
            }
        })

        arguments.getString(Constant.KEY_PHOTO_DATA)?.let {
            Log.d("TAG", "photoId $it")
            presenter?.loadPhotoInfo(it)
        }

        img_large_view.setOnClickListener {
            // view visible/gone
        }

        fab.setOnClickListener { presenter?.getPhotoDetailUrl(Constant.TYPE_DETAIL_PAGE) }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater?.inflate(R.menu.menu_detail, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_share -> {
                presenter?.getPhotoDetailUrl(Constant.TYPE_SHARE_URL)
                return true
            }
            R.id.action_info -> {
                presenter?.getPhotoDetailUrl(Constant.TYPE_DETAIL_PAGE)
                return true
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
        // Use a CustomTabsIntent.Builder to configure CustomTabsIntent.
        // Once ready, call CustomTabsIntent.Builder.build() to create a CustomTabsIntent
        // and launch the desired Url with CustomTabsIntent.launchUrl()
        val builder = CustomTabsIntent.Builder()
        // Changes the background color for the omnibox. colorInt is an int
        // that specifies a Color.
        builder.setToolbarColor(resources.getColor(R.color.colorPrimary))

        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(context as Activity, Uri.parse(photoPageUrl))
    }

    override fun updateToolbarItem(buddyIcon: String, buddyName: String, imgUrl: String, imgTitle: String) {
        rlToolbarUserInfo.visibility = View.VISIBLE
        rlToolbarImageInfo.visibility = View.GONE

        tvToolbarBuddyName.text = buddyName
        // Buddy icon
        Glide.with(context)
                .load(buddyIcon)
                .centerCrop()
                .crossFade()
                .into(imgToolbarBuddyIcon)

        tvToolbarImageTitle.text = imgTitle
        // small image
        Glide.with(context)
                .load(imgUrl)
                .centerCrop()
                .crossFade()
                .into(imgToolbarSmall)
    }

    override fun updateItem(photo: FlickrPhoto) {
        img_large_view?.let {
            Glide.with(context)
                    .load(photo.getImageUrl())
                    .fitCenter()
                    .crossFade()
                    .into(img_large_view)
        }

        tvBottomTitle.text = photo.title.toString()
        tvBottomContent.text = Html.fromHtml(photo.description._content)
        tvBottomDate.text = photo.dates.lastupdate.getDate("MM-dd-yyyy hh:mm")
        tvBottomViewerCount.text = photo.views.decimalFormat()
        tvBottomCommentCount.text = photo.comments._content.decimalFormat()
    }
}