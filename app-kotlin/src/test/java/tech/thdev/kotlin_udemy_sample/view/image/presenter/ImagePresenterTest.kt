package tech.thdev.kotlin_udemy_sample.view.image.presenter

import org.awaitility.Awaitility.await
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource
import tech.thdev.kotlin_udemy_sample.view.image.adapter.ImageAdapter

/**
 * Created by tae-hwan on 11/13/16.
 */
class ImagePresenterTest {

    val view: ImageContract.View
    val presenter: ImagePresenter

    init {
        view = mock(ImageContract.View::class.java)
        presenter = ImagePresenter()
    }

    @Before
    fun setUp() {
        presenter.view = view
        presenter.photoDataSample = PhotoDataSource
    }

    @Test
    fun getRecentImageSample() {
        var finish = false
        doAnswer {
            finish = true
            it
        }.`when`(view).showLoadSuccess()

        presenter.getRecentImageSample(ImageAdapter.VIEW_TYPE_GLIDE)

        await().untilAsserted {
            while (finish.not()) {
                println()
            }
        }

        verify(view).showLoadSuccess()
    }
}