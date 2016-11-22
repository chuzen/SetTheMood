package com.jcbapps.j.setthemood;

import android.content.pm.ActivityInfo;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Joaquin on 3/10/2016.
 * Unit test for HomeActivity
 */

@RunWith(AndroidJUnit4.class)
public class HomeActivityTest {

    @Rule
    public ActivityTestRule<HomeActivity> activityTestRule = new ActivityTestRule<>(HomeActivity.class);

    // Make app scroll to the bottom
    @Test
    public void testScrollDown() {
        onView(withId(R.id.scroll_view)).perform(swipeUp());
    }

    // Make app scroll to the top
    @Test
    public void testScrollUp() {
        onView(withId(R.id.scroll_view)).perform(swipeDown());
    }

    // Confirms launch of Happy button
    @Test
    public void testHomeButtonLauncher() {
        onView(withId(R.id.happy_button)).perform(click());
        onView(withId(R.id.songs_list)).check(matches(withId(R.id.songs_list)));
    }

    // Confirms launch of Sad button
    @Test
    public void testSadButtonLauncher() {
        onView(withId(R.id.sad_button)).perform(click());
        onView(withId(R.id.songs_list)).check(matches(withId(R.id.songs_list)));
    }

    // Confirms launch of Drunk button
    @Test
    public void testDrunkButtonLauncher() {
        onView(withId(R.id.drunk_button)).perform(click());
        onView(withId(R.id.songs_list)).check(matches(withId(R.id.songs_list)));
    }

    // Confirms launch of Angry button
    @Test
    public void testAngryButtonLauncher() {
        onView(withId(R.id.angry_button)).perform(click());
        onView(withId(R.id.songs_list)).check(matches(withId(R.id.songs_list)));
    }

    // Confirms launch of High button
    @Test
    public void testHighButtonLauncher() {
        onView(withId(R.id.high_button)).perform(click());
        onView(withId(R.id.songs_list)).check(matches(withId(R.id.songs_list)));
    }

    // Confirms launch of Excited button
    @Test
    public void testExcitedButtonLauncher() {
        onView(withId(R.id.excited_button)).perform(click());
        onView(withId(R.id.songs_list)).check(matches(withId(R.id.songs_list)));
    }


    // Confirms launch of Relaxed button
    @Test
    public void testRelaxedButtonLauncher() {
        onView(withId(R.id.relaxed_button)).perform(click());
        onView(withId(R.id.songs_list)).check(matches(withId(R.id.songs_list)));
    }

    // Confirms launch of Lazy button
    @Test
    public void testLazyButtonLauncher() {
        onView(withId(R.id.lazy_button)).perform(click());
        onView(withId(R.id.songs_list)).check(matches(withId(R.id.songs_list)));
    }

    // Test rotation of the device
    @Test
    public void testDeviceRotation() {
        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}
