package tech.thdev.kotlin_udemy_sample.view.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.design.widget.BottomSheetBehavior
import android.support.v4.view.ViewPager
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_more.*
import kotlinx.android.synthetic.main.bottom_sheet_detail_view.*
import tech.thdev.base.view.BasePresenterActivity
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.constant.Constant
import tech.thdev.kotlin_udemy_sample.data.FlickrPhoto
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource
import tech.thdev.kotlin_udemy_sample.util.decimalFormat
import tech.thdev.kotlin_udemy_sample.util.getDate
import tech.thdev.kotlin_udemy_sample.view.detail.adapter.SectionsPagerAdapter
import tech.thdev.kotlin_udemy_sample.view.detail.presenter.DetailMoreContract
import tech.thdev.kotlin_udemy_sample.view.detail.presenter.DetailMorePresenter

class DetailMoreActivity : BasePresenterActivity<DetailMoreContract.View, DetailMoreContract.Presenter>(),
        ViewPager.OnPageChangeListener, DetailMoreContract.View {

    private var selectionPagerAdapter: SectionsPagerAdapter? = null

    private val bottomSheet by lazy {
        BottomSheetBehavior.from(rl_sheet_view)
    }

    override fun onCreatePresenter() = DetailMorePresenter()

    private var currentPosition = 0

    /**
     * Info icon showing
     */
    private var isShowInfoIcon = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_more)

        setSupportActionBar(toolbar)
        title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        presenter?.photoDataSource = PhotoDataSource

        selectionPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // pagerModel setting
        presenter?.pagerModel = selectionPagerAdapter
        presenter?.setRecentItemList(intent)

        currentPosition = intent.getIntExtra(Constant.KEY_SHOW_POSITION, 0)

        container.adapter = selectionPagerAdapter
        container.addOnPageChangeListener(this)
        container.setCurrentItem(currentPosition, false)

        onCreateView()

        presenter?.loadPhotoInfo(currentPosition)
    }

    private fun onCreateView() {
        bottomSheet.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                if (slideOffset > 0.9) {
                    rl_toolbar_user_info.visibility = View.GONE
                    rl_toolbar_image_info.visibility = View.VISIBLE
                    tv_title.visibility = View.INVISIBLE

                    isShowInfoIcon = true

                } else {
                    rl_toolbar_user_info.visibility = View.VISIBLE
                    rl_toolbar_image_info.visibility = View.GONE
                    tv_title.visibility = View.VISIBLE

                    isShowInfoIcon = false
                }
                invalidateOptionsMenu()
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    onBackPressed()
                }
            }
        })

        fab.setOnClickListener { presenter?.getPhotoDetailUrl(Constant.TYPE_DETAIL_PAGE) }
    }

    override fun onDestroy() {
        super.onDestroy()
        container.removeOnPageChangeListener(this)
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
                presenter?.getPhotoDetailUrl(Constant.TYPE_SHARE_URL)
            }
            R.id.action_info -> {
                presenter?.getPhotoDetailUrl(Constant.TYPE_DETAIL_PAGE)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        currentPosition = position

        presenter?.loadPhotoInfo(currentPosition)
    }

    override fun updateToolbarItem(buddyIcon: String, buddyName: String, imgUrl: String, imgTitle: String) {
        rl_toolbar_user_info.visibility = View.VISIBLE
        rl_toolbar_image_info.visibility = View.GONE

        tv_buddy_name.text = buddyName
        // Buddy icon
        Glide.with(this)
                .load(buddyIcon)
                .centerCrop()
                .crossFade()
                .into(img_buddy_icon)

        tv_toolbar_title.text = imgTitle
        // small image
        Glide.with(this)
                .load(imgUrl)
                .centerCrop()
                .crossFade()
                .into(img_small)
    }

    override fun updateItem(photo: FlickrPhoto) {
        tv_title.text = photo.title.toString()
        tv_content.text = Html.fromHtml(photo.description._content)
        tv_date.text = photo.dates.lastupdate.getDate("MM-dd-yyyy hh:mm")
        tv_viewer_count.text = photo.views.decimalFormat()
        tv_comment_count.text = photo.comments._content.decimalFormat()
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
        customTabsIntent.launchUrl(this, Uri.parse(photoPageUrl))
    }
}
