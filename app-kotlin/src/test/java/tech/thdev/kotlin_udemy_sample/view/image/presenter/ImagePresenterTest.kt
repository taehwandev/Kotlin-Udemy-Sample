package tech.thdev.kotlin_udemy_sample.view.image.presenter

import org.awaitility.Awaitility.await
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource

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

        presenter.getRecentImageSample()

        await().untilAsserted {
            while (finish.not()) {
                println()
            }
        }

        // TODO 차례대로 테스트를 진행해보세요
        verify(view).showLoadSuccess()
//        verify(view).showLoadFail()
//        verify(view).showLoadFailMessage("Error")
    }
}