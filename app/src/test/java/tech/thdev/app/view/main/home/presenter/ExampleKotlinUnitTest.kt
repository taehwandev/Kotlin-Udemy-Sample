package tech.thdev.app.view.main.home.presenter

import com.nhaarman.expect.expect
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import org.junit.Test
import org.mockito.Mockito.`when`
import tech.thdev.app.data.Photo
import tech.thdev.app.data.source.flickr.FlickrRepository
import tech.thdev.app.view.main.home.adapter.model.ImageRecyclerModel

/**
 * Created by taehwankwon on 13/11/2017.
 */
class ExampleKotlinUnitTest {

    private val view = mock<HomeContract.View>()
    private val imageRecyclerModel = mock<ImageRecyclerModel>()

    private val presenter:HomePresenter = HomePresenter(view, FlickrRepository, imageRecyclerModel)

    @Test
    fun testGetItem() {
        val photo = Photo("", "", "", "", 1, "", 0, 0, 0)
        val mock = mock<ImageRecyclerModel> {
            on { getItem(0) } doReturn photo
        }

        /* when */
        val result = mock.getItem(0)

        /* Then */
        expect(result).toBe(photo)
    }

    @Test
    fun testGetItemTwo() {
        val list = ArrayList<Photo>()
        list.add(Photo("30970646001", "", "554f4e63ac", "5481", 6, "Perfection in purple", 1, 1, 1))
        list.add(Photo("30982050221", "", "a5bf714923", "5451", 6, "Monument Valley", 1, 1, 1))
        list.add(Photo("30941531532", "", "a9bd7545d9", "5569", 6, "American Oystercatcher", 1, 1, 1))

        `when`(presenter.imageRecyclerModel.getItem(0)).thenReturn(list[0])

        val result = presenter.imageRecyclerModel.getItem(0)

        expect(result).toBe(list[0])
    }
}