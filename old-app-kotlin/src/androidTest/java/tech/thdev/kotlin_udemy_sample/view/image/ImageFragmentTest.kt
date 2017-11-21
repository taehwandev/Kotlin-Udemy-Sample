package tech.thdev.kotlin_udemy_sample.view.image

import android.support.test.InstrumentationRegistry.getInstrumentation
import android.support.test.espresso.Espresso.*
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.view.View
import android.view.ViewGroup
import com.jayway.awaitility.Awaitility
import org.hamcrest.BaseMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.view.image.adapter.holder.ImageGlideViewHolder


/**
 * Kotlin Test를 위해서는 코틀린 junit test을 추가해야 함
 *
 * androidTestCompile "org.jetbrains.kotlin:kotlin-test-junit:1.0.5"
 *
 * kotlin testing 참고 자료
 * https://medium.com/@sergii/using-kotlin-for-tests-in-android-6d4a0c818776#.ios8lnr1u
 *
 * Espresso – Testing RecyclerViews at Specific Positions
 * https://spin.atomicobject.com/2016/04/15/espresso-testing-recyclerviews/
 *
 * Android user interface testing with Espresso - Tutorial
 * http://www.vogella.com/tutorials/AndroidTestingEspresso/article.html
 */
class ImageFragmentTest {

    @get:Rule
    val rule: ActivityTestRule<ImageActivity> = ActivityTestRule(ImageActivity::class.java)

    private var fragment: ImageFragment? = null

    @Before
    fun setUp() {
        fragment = rule.activity.supportFragmentManager.findFragmentById(R.id.frame_layout) as ImageFragment

        awaitItemLoad()
    }

    /**
     * Item click Test
     */
    @Test
    fun testAdapterItemClickTest() {
        val item = fragment?.presenter?.adapterModel?.getItem(0)

        onView(withId(R.id.recycler_image))
            .perform(RecyclerViewActions.actionOnItemAtPosition<ImageGlideViewHolder>(0, click()))

        onView(withId(R.id.tv_title)).check(ViewAssertions.matches(withText(item?.title)))
    }

    /**
     * More item check
     */
    @Test
    fun testItemCountCheck() {
        onView(withId(R.id.recycler_image))
                .check(ViewAssertions.matches(withItemSize(100)))

        onView(withId(R.id.fab)).perform(click())

        awaitItemLoad()

        onView(withId(R.id.recycler_image))
                .check(ViewAssertions.matches(withItemSize(199)))
    }

    @Test
    fun testScrollToPosition() {
        // Perform click on an element with a specific text
        val position = 98

        onView(withId(R.id.recycler_image))
                .perform(RecyclerViewActions.scrollToPosition<ImageGlideViewHolder>(position))

        val item = fragment?.presenter?.adapterModel?.getItem(position)

        onView(withId(R.id.recycler_image)).perform(RecyclerViewActions.actionOnItem<ImageGlideViewHolder>(
                hasDescendant(withText(item?.title)), click()))

        // DetailMoreActivity Test.
        onView(withId(R.id.tv_title)).check(ViewAssertions.matches(withText(item?.title)))
    }

    @Test
    fun testCheckListViewItem() {
        val item = fragment?.presenter?.adapterModel?.getItem(2)

        /*
         * recycler_image에 item의 title을 포함하는지 체크
         */
        onView(nthChildOf(withId(R.id.recycler_image), 2))
                .check(ViewAssertions.matches(hasDescendant(withText(item?.title))))

        /*
         * recycler_image에 포함된 ImageGrlidViewHolder에 item.title을 포함하고 있을 경우 click 발생
         */
        onView(withId(R.id.recycler_image)).perform(RecyclerViewActions.actionOnItem<ImageGlideViewHolder>(
                hasDescendant(withText(item?.title)), click()))

        /*
         * tv_title에 item.title이 정상적으로 표시되고 있는지 Test
         */
        onView(allOf(withId(R.id.tv_title), withText(item?.title))).check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun testMenuChange() {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().targetContext)

        onView(withText("Image Loader")).perform(click())
        onView(withText("Thread")).perform(click())

        Thread.sleep(1000)

        onData(allOf(withText("Thread")))
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
                return itemSize == fragment?.presenter?.adapterModel?.getItems()?.size ?: 0
            }

            override fun describeTo(description: Description?) {

            }
        }
    }

    /**
     * <a href="https://medium.com/@_rpiel/recyclerview-and-espresso-a-complicated-story-3f6f4179652e#.mlzxziks7">RecyclerView and espresso, a complicated story</a>
     */
    fun nthChildOf(parentMatcher: Matcher<View>, childPosition: Int): Matcher<View> {
        return object : TypeSafeMatcher<View>() {

            override fun matchesSafely(item: View?): Boolean {
                if (item?.parent !is ViewGroup) {
                    return parentMatcher.matches(item?.parent)
                }

                return parentMatcher.matches(item?.parent) && (item?.parent as ViewGroup).getChildAt(childPosition) == item
            }

            override fun describeTo(description: Description?) {
                description?.appendText("with $childPosition child view of type parentMatcher")
            }
        }
    }

    /**
     * Waiting to load items
     */
    fun awaitItemLoad() {
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