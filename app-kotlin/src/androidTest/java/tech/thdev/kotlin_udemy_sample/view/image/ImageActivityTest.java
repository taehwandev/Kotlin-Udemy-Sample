package tech.thdev.kotlin_udemy_sample.view.image;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import tech.thdev.kotlin_udemy_sample.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ImageActivityTest {

    @Rule
    public ActivityTestRule<ImageActivity> mActivityTestRule = new ActivityTestRule<>(ImageActivity.class);

    @Test
    public void imageActivityTest() throws Exception {
        ViewInteraction imageView = onView(
                allOf(withId(R.id.image),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.recycler_image),
                                        2),
                                1),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.recycler_image), isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(1, click()));

        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.image),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.recycler_image),
                                        3),
                                1),
                        isDisplayed()));
        imageView2.check(matches(isDisplayed()));

        ViewInteraction appCompatImageView = onView(
                allOf(withId(R.id.img_large_view), isDisplayed()));
        appCompatImageView.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.tv_title), withText("FlickrContent(_content=Nothing gold can stay)"),
                        childAtPosition(
                                allOf(withId(R.id.rl_sheet_view),
                                        childAtPosition(
                                                withId(R.id.main_content),
                                                2)),
                                0),
                        isDisplayed()));
        textView.check(matches(isDisplayed()));

        ViewInteraction scrollView = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(R.id.rl_sheet_view),
                                0),
                        1),
                        isDisplayed()));
        scrollView.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.tv_toolbar_title), withText("Nothing gold can stay"),
                        childAtPosition(
                                allOf(withId(R.id.rl_toolbar_image_info),
                                        childAtPosition(
                                                withId(R.id.toolbar),
                                                1)),
                                1),
                        isDisplayed()));
        textView2.check(matches(withText("Nothing gold can stay")));

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab),
                        withParent(allOf(withId(R.id.main_content),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        floatingActionButton.perform(click());

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
}
