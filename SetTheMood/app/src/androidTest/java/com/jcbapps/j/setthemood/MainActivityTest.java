package com.jcbapps.j.setthemood;

import android.content.pm.ActivityInfo;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.jcbapps.j.setthemood.R.id.songs_list;
import static org.hamcrest.Matchers.allOf;


/**
 * Created by Joaquin on 3/10/2016.
 * Expanded by Chunda on 10/10/2016.
 * Unit test for MainActivity
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity>{

    private String query;

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @SuppressWarnings("deprecation")
    public MainActivityTest() {
        // This constructor was deprecated - but we want to support lower API levels.
        super("com.jcbapps.j.setthemood;", MainActivity.class);

    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        // Espresso will not launch our activity for us, we must launch it via getActivity().
        getActivity();
    }

    @Before
    public void initValidString() {
        query = "2pac";
    }


    // Confirms launch of a song on the list to display the toolbar for it
    @Test
    public void testSongItemLauncher() {
        onView(withId(songs_list)).perform(click());
        onView(withId(R.id.player_toolbar)).check(matches(withId(R.id.player_toolbar)));


        //added by Chunda
        // confirms the play/pause button works
        onView(withId(R.id.player_state)).perform(closeSoftKeyboard());
        onView(withId(R.id.player_state)).check(matches(allOf(isEnabled(), isClickable()))).perform(
                new ViewAction() {
                    @Override
                    public Matcher<View> getConstraints() {
                        return isEnabled(); // no constraints, they are checked above
                    }

                    @Override
                    public String getDescription() {
                        return "click plus button";
                    }

                    @Override
                    public void perform(UiController uiController, View view) {
                        view.performClick();
                    }
                }
        );

        //added by Chunda
        //confirms the search bar is enabled
        onView(withId(R.id.search_view)).perform(click());
        onView(withId(R.id.search_view)).check(matches(isEnabled()));


        // added by Chunda
        // confirms if the empty text is entered
        onView(withId(R.id.search_view)).perform(typeText(""));


        // added by Chunda
        // unit test for user input in the search bar
        onView(withId(R.id.search_view)).perform(typeText(query));

        // added by Chunda
        // performs the search and returns the list with query
        onView(withText(query)).perform(pressImeActionButton());
        onView(withId(songs_list)).perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
        onView(withId(songs_list)).check(matches(isDisplayed()));

        // added by Chunda
        //check to see if the first song is clicked
        onData(withId(R.id.songs_list)).perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));

        /*
        onView(withId(R.id.songs_list)).check(new RecylerViewItemCountAssertion(9));
        Log.d("test", "" + new RecylerViewItemCountAssertion(9) + " songs");
        */

    }



    // added by Chunda
    // Test rotation of the device
    @Test
    public void testDeviceRotation() {
        activityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }




}




