package com.example.madt_p2;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.MediumTest;

import org.junit.Test;
import org.junit.Rule;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

@MediumTest
public class MainActivityUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testWhenTextStringIsEnteredToTxtMainOnOptionWords() {
        final String givenString = "Hello World!";
        final String expectedResult = "2 Words";

        onView(withId(R.id.etInput)).perform(click(), replaceText(givenString), closeSoftKeyboard());
        onView(withId(R.id.btnCount)).perform(click());
        onView(withId(R.id.tvOutput)).check(matches(withText(expectedResult)));
    }

    @Test
    public void testWhenTextStringIsEnteredToTxtMainOnOptionCharacters() {
        final String givenString = "Hello World!";
        final String expectedResult = "12 Characters";

        onView(withId(R.id.etInput)).perform(click(), replaceText(givenString), closeSoftKeyboard());
        onView(withId(R.id.spinnerMethod)).perform(click());
        onData(anything()).atPosition(1).perform(click());
        onView(withId(R.id.btnCount)).perform(click());
        onView(withId(R.id.tvOutput)).check(matches(withText(expectedResult)));
    }
}