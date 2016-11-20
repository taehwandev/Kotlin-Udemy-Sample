package tech.thdev.kotlin_udemy_sample.view.image.presenter

import com.jayway.awaitility.Awaitility.await
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.*
import tech.thdev.kotlin_udemy_sample.data.RecentPhotoItem
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource
import tech.thdev.kotlin_udemy_sample.listener.OnItemTouchListener
import tech.thdev.kotlin_udemy_sample.view.image.adapter.ImageAdapter
import tech.thdev.kotlin_udemy_sample.view.image.adapter.model.ImageViewAdapterContract
import java.util.*

/**
 * Created by tae-hwan on 11/13/16.
 */
class ImagePresenterTest {

    /**
     * Adapter에 Data을 전달하고, 가져온다
     */
    val adapterModel: ImageViewAdapterContract.Model
    val adapterView: ImageViewAdapterContract.View

    val view: ImageContract.View
    val presenter: ImagePresenter

    init {
        // adapterModel에 대한 Mock 추가
        adapterModel = mock(ImageViewAdapterContract.Model::class.java)
        adapterView = mock(ImageViewAdapterContract.View::class.java)

        // View에 대한 Mock 추가
        view = mock(ImageContract.View::class.java)
        presenter = ImagePresenter()
    }

    @Before
    fun setUp() {
        presenter.view = view
        presenter.photoDataSample = PhotoDataSource
        presenter.adapterModel = adapterModel
        presenter.adapterView = adapterView
    }

    @Test
    fun testLoadSuccess() {
        var finish = false

        /* When */
        doAnswer {
            finish = true
            it
        }.`when`(view).showLoadSuccess()

        /* Given */
        presenter.getRecentImageSample(ImageAdapter.VIEW_TYPE_GLIDE)

        await().until {
            while (!finish) {
                verify(adapterModel, atLeastOnce()).addItem(ArgumentMatchers.any(RecentPhotoItem::class.java))
            }
        }

        /* Then */
        verify(view).showLoadSuccess()
    }

    @Test
    fun testAdapterReload() {
        var finish = false

        /* When */
        doAnswer {
            finish = true
            it
        }.`when`(adapterView).reload()

        /* Given */
        presenter.getRecentImageSample(ImageAdapter.VIEW_TYPE_GLIDE)

        await().until {
            while (!finish) {
                verify(adapterModel, atLeastOnce()).addItem(ArgumentMatchers.any(RecentPhotoItem::class.java))
            }
        }

        /* Then */
        verify(adapterView).reload()
    }

    @Test
    fun testOnItemClick() {
        val list = ArrayList<RecentPhotoItem>()
        list.add(RecentPhotoItem("30970646001", "", "554f4e63ac", "5481", 6, "Perfection in purple", 1, 1, 1, 0))
        list.add(RecentPhotoItem("30982050221", "", "a5bf714923", "5451", 6, "Monument Valley", 1, 1, 1, 0))
        list.add(RecentPhotoItem("30941531532", "", "a9bd7545d9", "5569", 6, "American Oystercatcher", 1, 1, 1, 0))

        `when`(presenter.adapterModel?.getItems()).thenReturn(list)

        `when`(presenter.adapterView?.onItemClickListener?.onItemClick(0)).thenAnswer {
            object : OnItemTouchListener {
                override fun onItemClick(position: Int) {
                    presenter.adapterModel?.getItems()?.let {
                        view.showDetailMore(it, 0)
                    }
                }
            }
        }

        /* When */
        presenter.adapterView?.onItemClickListener?.onItemClick(0)

        verify(view).showDetailMore(presenter.adapterModel?.getItems() ?: ArrayList<RecentPhotoItem>(), 0)
    }
}