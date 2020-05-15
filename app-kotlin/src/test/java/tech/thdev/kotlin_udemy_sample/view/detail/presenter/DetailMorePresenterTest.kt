package tech.thdev.kotlin_udemy_sample.view.detail.presenter

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import tech.thdev.kotlin_udemy_sample.data.RecentPhotoItem
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource
import tech.thdev.kotlin_udemy_sample.view.detail.adapter.model.SectionsPagerModel
import java.util.*

/**
 * Created by tae-hwan on 11/20/16.
 */
class DetailMorePresenterTest {

    val adapterModel: SectionsPagerModel
    val view: DetailMoreContract.View
    val presenter: DetailMoreContract.Presenter

    init {
        adapterModel = mock(SectionsPagerModel::class.java)
        view = mock(DetailMoreContract.View::class.java)
        presenter = DetailMorePresenter()
    }

    private val list = ArrayList<RecentPhotoItem>()

    @Before
    fun setUp() {
        presenter.pagerModel = adapterModel
        presenter.photoDataSource = PhotoDataSource

        list.add(RecentPhotoItem("30970646001", "", "554f4e63ac", "5481", 6, "Perfection in purple", 1, 1, 1, 0))
        list.add(RecentPhotoItem("30982050221", "", "a5bf714923", "5451", 6, "Monument Valley", 1, 1, 1, 0))
        list.add(RecentPhotoItem("30941531532", "", "a9bd7545d9", "5569", 6, "American Oystercatcher", 1, 1, 1, 0))
    }

    @Test
    fun testItemLoad() {
        `when`(adapterModel.getPhotoId(0)).thenReturn(list[0].id)

        presenter.loadPhotoInfo(0)

        verify(adapterModel).getPhotoId(0)
        assertEquals(adapterModel.getPhotoId(0), list[0].id)
    }

    @After
    fun tearDown() {
        list.clear()
    }
}