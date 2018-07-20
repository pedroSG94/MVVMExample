package com.pedro.mvvmexample

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.pedro.mvvmexample.ui.MainActivity
import junit.framework.Assert
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

  @get:Rule
  val rule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

  //Test if data binding set success to TextView in activity
  @Test
  fun success() {
    val activity = rule.activity
    Assert.assertEquals("Success", activity.tv_info.text)
  }
}