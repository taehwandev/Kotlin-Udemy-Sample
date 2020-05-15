package tech.thdev.kotlin_udemy_sample.view.image;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.awaitility.Awaitility;
import org.awaitility.core.ThrowingRunnable;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import tech.thdev.kotlin_udemy_sample.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ImageActivityTest {

    @Rule
    public ActivityTestRule<ImageActivity> mActivityTestRule = new ActivityTestRule<>(ImageActivity.class);

    private ImageFragment fragment;

    @Before
    public void setUp() {
        fragment = (ImageFragment) mActivityTestRule.getActivity().getSupportFragmentManager().findFragmentById(R.id.frame_layout);

        awaitImageLoad();
    }

    @Test
    public void imageActivityTest() {
        ViewInteraction textView = onView(
                allOf(withId(R.id.tv_title), withText("\"Little beauty \""),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.recycler_image),
                                        3),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("\"Little beauty \"")));

        ViewInteraction relativeLayout = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.recycler_image),
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                        0)),
                        3),
                        isDisplayed()));
        relativeLayout.check(matches(isDisplayed()));

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.recycler_image), isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(3, click()));

        pressBack();

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.recycler_image), isDisplayed()));
        recyclerView2.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.tv_title), withText("FlickrContent(_content=Perfection in purple)"),
                        childAtPosition(
                                allOf(withId(R.id.rl_sheet_view),
                                        childAtPosition(
                                                withId(R.id.main_content),
                                                2)),
                                0),
                        isDisplayed()));
        textView2.check(matches(withText("FlickrContent(_content=Perfection in purple)")));

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.action_info), withContentDescription("Info"), isDisplayed()));
        actionMenuItemView.perform(click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    /**
     * Waiting to load items
     */
    private void awaitImageLoad() {
        Awaitility.await().untilAsserted(new ThrowingRunnable() {
            boolean isFinish = false;

            @Override
            public void run() throws Throwable {
                while (!isFinish) {
                    isFinish = !fragment.isLoading();
                }
            }
        });
    }
}
