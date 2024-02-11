package tech.thdev.kotlin_udemy_sample.view.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.browser.customtabs.CustomTabsIntent
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.base.ui.BasePresenterActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.constant.Constant
import tech.thdev.kotlin_udemy_sample.data.FlickrPhoto
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource
import tech.thdev.kotlin_udemy_sample.databinding.ActivityDetailMoreBinding
import tech.thdev.kotlin_udemy_sample.databinding.BottomSheetDetailViewBinding
import tech.thdev.kotlin_udemy_sample.util.decimalFormat
import tech.thdev.kotlin_udemy_sample.util.getDate
import tech.thdev.kotlin_udemy_sample.view.detail.adapter.SectionsPagerAdapter
import tech.thdev.kotlin_udemy_sample.view.detail.presenter.DetailMoreContract
import tech.thdev.kotlin_udemy_sample.view.detail.presenter.DetailMorePresenter

class DetailMoreActivity :
    BasePresenterActivity<DetailMoreContract.View, DetailMoreContract.Presenter>(),
    ViewPager.OnPageChangeListener, DetailMoreContract.View {

    private var selectionPagerAdapter: SectionsPagerAdapter? = null

    private lateinit var activityDetailMoreBinding: ActivityDetailMoreBinding

    private val rlSheetView: BottomSheetDetailViewBinding by lazy {
        activityDetailMoreBinding.rlSheetView
    }

    private val bottomSheet by lazy {
        BottomSheetBehavior.from(rlSheetView.sheetView)
    }

    override fun onCreatePresenter() = DetailMorePresenter()

    private var currentPosition = 0

    /**
     * Info icon showing
     */
    private var isShowInfoIcon = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailMoreBinding = ActivityDetailMoreBinding.inflate(layoutInflater)
        setContentView(activityDetailMoreBinding.root)

        setSupportActionBar(activityDetailMoreBinding.toolbar)
        title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        presenter?.photoDataSource = PhotoDataSource

        selectionPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // pagerModel setting
        presenter?.pagerModel = selectionPagerAdapter
        presenter?.setRecentItemList(intent)

        currentPosition = intent.getIntExtra(Constant.KEY_SHOW_POSITION, 0)

        activityDetailMoreBinding.container.adapter = selectionPagerAdapter
        activityDetailMoreBinding.container.addOnPageChangeListener(this)
        activityDetailMoreBinding.container.setCurrentItem(currentPosition, false)

        onCreateView()

        presenter?.loadPhotoInfo(currentPosition)
    }

    private fun onCreateView() {
        bottomSheet.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                if (slideOffset > 0.9) {
                    activityDetailMoreBinding.rlToolbarUserInfo.visibility = View.GONE
                    activityDetailMoreBinding.rlToolbarImageInfo.visibility = View.VISIBLE
                    rlSheetView.tvTitle.visibility = View.INVISIBLE

                    isShowInfoIcon = true

                } else {
                    activityDetailMoreBinding.rlToolbarUserInfo.visibility = View.VISIBLE
                    activityDetailMoreBinding.rlToolbarImageInfo.visibility = View.GONE
                    rlSheetView.tvTitle.visibility = View.VISIBLE

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

        activityDetailMoreBinding.fab.setOnClickListener { presenter?.getPhotoDetailUrl(Constant.TYPE_DETAIL_PAGE) }
    }

    override fun onDestroy() {
        super.onDestroy()
        activityDetailMoreBinding.container.removeOnPageChangeListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menu?.findItem(R.id.action_info)?.isVisible = isShowInfoIcon
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.action_share -> {
                presenter?.getPhotoDetailUrl(Constant.TYPE_SHARE_URL)
            }

            R.id.action_info -> {
                presenter?.getPhotoDetailUrl(Constant.TYPE_DETAIL_PAGE)
            }

            android.R.id.home -> {
                onBackPressed()
                return true
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

    override fun updateToolbarItem(
        buddyIcon: String,
        buddyName: String,
        imgUrl: String,
        imgTitle: String
    ) {
        activityDetailMoreBinding.rlToolbarUserInfo.visibility = View.VISIBLE
        activityDetailMoreBinding.rlToolbarImageInfo.visibility = View.GONE

        activityDetailMoreBinding.tvBuddyName.text = buddyName
        // Buddy icon
        Glide.with(this)
            .load(buddyIcon)
            .centerCrop()
            .into(activityDetailMoreBinding.imgBuddyIcon)

        activityDetailMoreBinding.tvToolbarTitle.text = imgTitle
        // small image
        Glide.with(this)
            .load(imgUrl)
            .centerCrop()
            .into(activityDetailMoreBinding.imgSmall)
    }

    override fun updateItem(photo: FlickrPhoto) {
        rlSheetView.run {
            tvTitle.text = photo.title.toString()
            tvContent.text = Html.fromHtml(photo.description._content)
            tvDate.text = photo.dates.lastupdate.getDate("MM-dd-yyyy hh:mm")
            tvViewerCount.text = photo.views.decimalFormat()
            tvCommentCount.text = photo.comments._content.decimalFormat()
        }
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
        builder.setToolbarColor(resources.getColor(R.color.purple700))

        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(photoPageUrl))
    }
}
