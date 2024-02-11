package tech.thdev.app.view.main.detail

import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import tech.thdev.app.R
import tech.thdev.app.data.source.flickr.FlickrRepository
import tech.thdev.app.databinding.LayoutPhotoDetailBinding
import tech.thdev.app.view.main.detail.presenter.DetailImageContract
import tech.thdev.app.view.main.detail.presenter.DetailImagePresenter


/**
 * Created by taehwankwon on 12/11/2017.
 */
class DetailImageBottomSheet : BottomSheetDialogFragment(), DetailImageContract.View {

    companion object {
        const val KEY_PHOTO_ID = "key-photo-id"

        fun create(photoId: String): DetailImageBottomSheet = DetailImageBottomSheet().apply {
            arguments = Bundle().apply {
                putString(KEY_PHOTO_ID, photoId)
            }
        }
    }

    private val detailImagePresenter: DetailImagePresenter by lazy {
        DetailImagePresenter(this@DetailImageBottomSheet, FlickrRepository)
    }

    private lateinit var layoutPhotoDetailBinding: LayoutPhotoDetailBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setOnShowListener {
            val bottomSheet =
                dialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            BottomSheetBehavior.from(bottomSheet).apply {
                state = BottomSheetBehavior.STATE_EXPANDED
                peekHeight = 30
                addBottomSheetCallback(bottomSheetCallback)
            }
        }
        return dialog
    }

    private val bottomSheetCallback = object : BottomSheetBehavior.BottomSheetCallback() {
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
    }

    private fun updateToolbarVisibility() {
        when (layoutPhotoDetailBinding.appBar.visibility) {
            View.VISIBLE -> {
                layoutPhotoDetailBinding.appBar.visibility = View.INVISIBLE
                layoutPhotoDetailBinding.viewContentContainer.visibility = View.INVISIBLE
                view?.systemUiVisibility = View.SYSTEM_UI_FLAG_LOW_PROFILE
            }

            else -> {
                layoutPhotoDetailBinding.appBar.visibility = View.VISIBLE
                layoutPhotoDetailBinding.viewContentContainer.visibility = View.VISIBLE
                view?.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        LayoutPhotoDetailBinding.inflate(inflater, container, false).also {
            layoutPhotoDetailBinding = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutPhotoDetailBinding.img.setOnClickListener {
            updateToolbarVisibility()
        }

        layoutPhotoDetailBinding.imgCloseBtn.setOnClickListener {
            dismiss()
        }

        layoutPhotoDetailBinding.imgWeb.setOnClickListener {
            detailImagePresenter.loadFlickrWebPage()
        }

        detailImagePresenter.loadDetailInfo(arguments?.getString(KEY_PHOTO_ID) ?: "")
    }

    override fun updateToolbarItem(buddyIcon: String, buddyName: String) {
        layoutPhotoDetailBinding.imgOwnerImage.loadImage(buddyIcon)
        layoutPhotoDetailBinding.tvOwnerName.text = buddyName
    }

    override fun updateItem(
        imageUrl: String,
        title: String,
        content: String,
        date: String,
        viewCount: String,
        commentCount: String
    ) {
        layoutPhotoDetailBinding.img.loadImage(imageUrl)

        layoutPhotoDetailBinding.tvTitle.text = title
        layoutPhotoDetailBinding.tvContent.text =
            Html.fromHtml(content, Html.FROM_HTML_MODE_COMPACT)
        layoutPhotoDetailBinding.tvDate.text = date
        layoutPhotoDetailBinding.tvViewerCount.text = viewCount
        layoutPhotoDetailBinding.tvCommentCount.text = commentCount
    }

    override fun showFlickrWebPage(url: String) {
        CustomTabsIntent.Builder().apply {
            setToolbarColor(resources.getColor(R.color.purple700))
        }.build().run {
            launchUrl(requireContext(), Uri.parse(url))
        }
    }
}