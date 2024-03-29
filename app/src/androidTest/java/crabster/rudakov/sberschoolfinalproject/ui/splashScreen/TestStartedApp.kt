package crabster.rudakov.sberschoolfinalproject.ui.splashScreen

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import crabster.rudakov.sberschoolfinalproject.R
import crabster.rudakov.sberschoolfinalproject.ui.main.view.MainActivity
import org.hamcrest.CoreMatchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Класс, реализующий проверку тест-кейса, при котором происходит корректный
 * запуск приложения
 * */
@LargeTest
@RunWith(AndroidJUnit4::class)
class TestStartedApp {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testStartedApp() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(2500)

        val editText = onView(
            allOf(
                withId(R.id.filter_edit_text), withText(""),
                isDisplayed()
            )
        )
        editText.check(matches(withText("")))
    }

}
