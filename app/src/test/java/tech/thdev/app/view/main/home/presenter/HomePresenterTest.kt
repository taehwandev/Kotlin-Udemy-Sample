package tech.thdev.app.view.main.home.presenter

import org.awaitility.Awaitility.await
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import tech.thdev.app.data.Photo
import tech.thdev.app.data.source.flickr.FlickrRepository
import tech.thdev.app.view.main.home.adapter.model.ImageRecyclerModel

/**
 * Created by taehwankwon on 12/11/2017.
 */
class HomePresenterTest {

    @Mock lateinit var view: HomeContract.View
    @Mock lateinit var imageRecyclerModel: ImageRecyclerModel

    private lateinit var presenter:HomePresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = HomePresenter(view, FlickrRepository, imageRecyclerModel)
    }

    @Test
    fun testOnClick() {
        var isFinish = false
        /* When */
        doAnswer {
            isFinish = true
            it
        }.`when`(view).hideProgress()

        /* Given */
        presenter.loadFlickrImage()

        await().untilAsserted {
            while (!isFinish) {
                verify(imageRecyclerModel, atLeastOnce()).addItem(ArgumentMatchers.any(Photo::class.java))
            }
        }

        /* Then */
        verify(view).hideProgress()
    }
}