package tech.thdev.kotlin_udemy_sample.view.detail

import android.content.Intent
import android.support.design.widget.BottomSheetBehavior
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.swipeLeft
import android.support.test.espresso.action.ViewActions.swipeRight
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import com.jayway.awaitility.Awaitility
import org.hamcrest.CoreMatchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.constant.Constant
import tech.thdev.kotlin_udemy_sample.data.RecentPhotoItem
import java.util.*

/**
 * Created by tae-hwan on 11/20/16.
 */
class DetailMoreActivityTest {

    @get:Rule
    val rule = ActivityTestRule<DetailMoreActivity>(DetailMoreActivity::class.java)

    private val list = ArrayList<RecentPhotoItem>()

    @Before
    fun setUp() {
        list.add(RecentPhotoItem("30970646001", "", "554f4e63ac", "5481", 6, "Perfection in purple", 1, 1, 1, 0))
        list.add(RecentPhotoItem("30982050221", "", "a5bf714923", "5451", 6, "Monument Valley", 1, 1, 1, 0))
        list.add(RecentPhotoItem("30941531532", "", "a9bd7545d9", "5569", 6, "American Oystercatcher", 1, 1, 1, 0))

        val intent = Intent()
        intent.putExtra(Constant.KEY_PHOTO_DATA, list)
        intent.putExtra(Constant.KEY_SHOW_POSITION, 1)
        rule.launchActivity(intent)

        waitLoad()
    }

    @Test
    fun testBottomSheet() {
        rule.activity.bottomSheet.state = BottomSheetBehavior.STATE_EXPANDED

        Thread.sleep(500)

        onView(withId(R.id.action_info)).check(ViewAssertions.matches(isDisplayed()))

        rule.activity.bottomSheet.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    @Test
    fun testViewPager() {
        // -> 2
        onView(withId(R.id.container)).perform(swipeLeft())
        // <- 1
        onView(withId(R.id.container)).perform(swipeRight())
        // <- 0
        onView(withId(R.id.container)).perform(swipeRight())
        waitLoad()

        Thread.sleep(500)

        onView(allOf(withId(R.id.tv_title), isDisplayed())).check(ViewAssertions.matches(withText(list[0].title)))
    }

    @After
    fun tearDown() {
        list.clear()
    }

    private fun waitLoad() {
        Awaitility.await().until<Boolean> {
            var finish = false
            while (!finish) {
                finish = rule.activity?.let {
                    !it.isLoading
                } ?: true
            }
            finish
        }
    }
}