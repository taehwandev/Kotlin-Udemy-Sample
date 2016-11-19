package tech.thdev.kotlin_udemy_sample.view.image

import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.BoundedMatcher
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.util.Log
import com.jayway.awaitility.Awaitility.await
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.data.RecentPhotoItem

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

        await().until<Boolean> {
            var finish = false
            print("finish $finish")
            while (!finish) {
                finish = fragment?.isLoading ?: false
                print("finish $finish")
            }
            finish
        }
    }

    @Test
    fun testAdapterItemClickTest() {
        print("test!!!!")
//        onData(allOf(withTitle("Flat"))).perform(click())

        onView(withId(R.id.tv_title)).check(matches(withText("Flat")))
    }

    fun withTitle(title: String): Matcher<RecentPhotoItem> {
        return object : BoundedMatcher<RecentPhotoItem, RecentPhotoItem>(RecentPhotoItem::class.java) {
            override fun matchesSafely(item: RecentPhotoItem?): Boolean {
                Log.d("TAG", "titile ${item?.title}")
                return item?.title?.startsWith(title) ?: false
            }

            override fun describeTo(description: Description?) {
                description?.appendText(title)
            }
        }
    }
}