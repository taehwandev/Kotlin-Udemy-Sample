package tech.thdev.app.view.main.detail

import android.app.Dialog
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialogFragment
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_photo_detail.*
import tech.thdev.app.R
import tech.thdev.app.data.source.flickr.FlickrRepository
import tech.thdev.app.view.main.detail.presenter.DetailImageContract
import tech.thdev.app.view.main.detail.presenter.DetailImagePresenter


/**
 * Created by taehwankwon on 12/11/2017.
 */
class DetailImageBottomSheet : BottomSheetDialogFragment(), DetailImageContract.View {

    companion object {
        const val KEY_PHOTO_ID = "key-photo-id"

        fun create(photoId: String): DetailImageBottomSheet
                = DetailImageBottomSheet().apply {
            arguments = Bundle().apply {
                putString(KEY_PHOTO_ID, photoId)
            }
        }
    }

    private val detailImagePresenter: DetailImagePresenter by lazy {
        DetailImagePresenter(this@DetailImageBottomSheet, FlickrRepository)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setOnShowListener {
            val bottomSheet = dialog.findViewById<View>(android.support.design.R.id.design_bottom_sheet)
            BottomSheetBehavior.from(bottomSheet).apply {
                state = BottomSheetBehavior.STATE_EXPANDED
                peekHeight = 30
                setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                    override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    }

                    override fun onStateChanged(bottomSheet: View, newState: Int) {
                        when (newState) {
                            BottomSheetBehavior.STATE_COLLAPSED -> {
                                if (!isRemoving) dismiss()
                            }
                            else -> {

                            }
                        }
                    }
                })
            }
        }
        return dialog
    }

    private fun updateToolbarVisibility() {
        when (app_bar.visibility) {
            View.VISIBLE -> {
                app_bar.visibility = View.INVISIBLE
                view_content_container.visibility = View.INVISIBLE
                view?.systemUiVisibility = View.SYSTEM_UI_FLAG_LOW_PROFILE
            }
            else -> {
                app_bar.visibility = View.VISIBLE
                view_content_container.visibility = View.VISIBLE
                view?.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = View.inflate(context, R.layout.layout_photo_detail, null)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        img.setOnClickListener {
            updateToolbarVisibility()
        }

        img_close_btn.setOnClickListener {
            dismiss()
        }

        img_web.setOnClickListener {
            detailImagePresenter.loadFlickrWebPage()
        }

        detailImagePresenter.loadDetailInfo(arguments.getString(KEY_PHOTO_ID))
    }

    override fun updateToolbarItem(buddyIcon: String, buddyName: String) {
        img_owner_image.loadImage(buddyIcon)
        tv_owner_name.text = buddyName
    }

    override fun updateItem(imageUrl: String, title: String, content: String, date: String, viewCount: String, commentCount: String) {
        img.loadImage(imageUrl)

        tv_title.text = title
        tv_content.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(content, Html.FROM_HTML_MODE_COMPACT)
        } else {
            Html.fromHtml(content)
        }
        tv_date.text = date
        tv_viewer_count.text = viewCount
        tv_comment_count.text = commentCount
    }

    override fun showFlickrWebPage(url: String) {
        CustomTabsIntent.Builder().apply {
            setToolbarColor(resources.getColor(R.color.colorPrimary))
        }.build().run {
            launchUrl(context, Uri.parse(url))
        }
    }
}