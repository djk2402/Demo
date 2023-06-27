package com.dhananjay.testapplication

import android.R
import android.support.test.rule.ActivityTestRule
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Rule
import org.junit.Test


internal class MainActivityTest {

    @get:Rule
    var rule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    /*test to check if recycerview has data and click*/
    @Test
    fun testSample() {
        if (getRVcount() > 0) {
            onView(withId(R.id.recyclerview)).perform(
                RecyclerViewActions.actionOnItemAtPosition(
                    0,
                    click()
                )
            )
        }
    }

    private fun getRVcount(): Int {
        val recyclerView =
            rule.getActivity().findViewById(R.id.recyclerview) as RecyclerView
        return recyclerView.adapter!!.itemCount
    }
}