package tech.thdev.kotlin_udemy_sample.view.image

import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.BoundedMatcher
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.util.Log
import com.jayway.awaitility.Awaitility
import org.hamcrest.BaseMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.data.RecentPhotoItem
import tech.thdev.kotlin_udemy_sample.view.image.adapter.holder.ImageGlideViewHolder

/**
 * Kotlin Test를 위해서는 코틀린 junit test을 추가해야 함
 *
 * androidTestCompile "org.jetbrains.kotlin:kotlin-test-junit:1.0.5"
 */
class ImageFragmentTest {

    @get:Rule
    val rule: ActivityTestRule<ImageActivity> = ActivityTestRule(ImageActivity::class.java, true, true)

    private var fragment: ImageFragment? = null

    @Before
    fun setUp() {
        fragment = rule.activity.supportFragmentManager.findFragmentById(R.id.frame_layout) as ImageFragment

        awaitItemLoaded()
    }

    /**
     * Item click Test
     */
    @Test
    fun testAdapterItemClickTest() {
        onView(withId(R.id.recycler_image))
            .perform(RecyclerViewActions.actionOnItemAtPosition<ImageGlideViewHolder>(0, click()))

        onView(withId(R.id.tv_title)).check(ViewAssertions.matches(withText("Perfection in purple")))
    }

    /**
     * More item check
     */
    @Test
    fun testItemCountCheck() {
        onView(withId(R.id.recycler_image))
                .check(ViewAssertions.matches(withItemSize(99)))

        onView(withId(R.id.fab)).perform(click())

        awaitItemLoaded()

        onView(withId(R.id.recycler_image))
                .check(ViewAssertions.matches(withItemSize(199)))
    }

    @Test
    fun testShowingDetailPage() {
//        onData(allOf(withTitle("avvv"))).perform(click())

//        onView(withId(R.id.tv_title)).check(matches(withText("Flat")))
//        onData(allOf(withTitle("Flat"))).inAdapterView(withId(R.id.recycler_image)).atPosition(0).perform(click());
        onData(withTitle("Flat")).perform(click())
    }

    fun withTitle(title: String): Matcher<RecentPhotoItem> {
        return object : BoundedMatcher<RecentPhotoItem, RecentPhotoItem>(RecentPhotoItem::class.java) {
            override fun matchesSafely(item: RecentPhotoItem?): Boolean {
                return item?.title?.equals(title) ?: false
            }

            override fun describeTo(description: Description?) {
                description?.appendText(title)
            }
        }
    }

    /**
     * <a href="https://android.googlesource.com/platform/frameworks/testing/+/android-support-test/espresso/sample/src/androidTest/java/android/support/test/testapp/LongListMatchers.java">LongListMatchers</a>
     * Creates a matcher against the text stored in R.id.item_size. This text is the size of the text
     * printed in R.id.item_content.
     */
    fun withItemSize(itemSize: Int): Matcher<Any> {
        // use preconditions to fail fast when a test is creating an invalid matcher.
        return object : BaseMatcher<Any>() {

            override fun matches(item: Any?): Boolean {
                Log.d("TAG", "itemSize $itemSize, item $item , fragmentSize ${fragment?.presenter?.adapterModel?.getItems()?.size}")
                return itemSize == fragment?.presenter?.adapterModel?.getItems()?.size ?: 0
            }

            override fun describeTo(description: Description?) {

            }
        }
    }

    /**
     * Waiting to load items
     */
    fun awaitItemLoaded() {
        Awaitility.await().until<Boolean> {
            var finish = false
            while (!finish) {
                finish = fragment?.let {
                    !it.isLoading
                } ?: true
            }
            finish
        }
    }
}