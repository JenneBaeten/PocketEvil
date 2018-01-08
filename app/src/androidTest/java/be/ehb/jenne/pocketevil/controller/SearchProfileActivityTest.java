package be.ehb.jenne.pocketevil.controller;


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
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import be.ehb.jenne.pocketevil.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SearchProfileActivityTest {

    @Rule
    public ActivityTestRule<SearchProfileActivity> mActivityTestRule = new ActivityTestRule<>(SearchProfileActivity.class);

    @Test
    public void searchProfileActivityTest() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.profileTextInput),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.svScrollView),
                                        1),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.profileTextInput),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.svScrollView),
                                        1),
                                0),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("jentonic-21485"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.profileTextInput), withText("jentonic-21485"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.svScrollView),
                                        1),
                                0),
                        isDisplayed()));
        appCompatEditText3.perform(pressImeActionButton());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.profileSearchButton), withText("Search"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.svScrollView),
                                        1),
                                1),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction textView = onView(
                allOf(withText("Jentonic#21485"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar_overview_profile),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                                0)),
                                3),
                        isDisplayed()));
        textView.check(matches(withText("Jentonic#21485")));

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
