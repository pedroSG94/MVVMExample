package com.pedro.mvvmexample

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.pedro.mvvmexample.ui.LoginActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

  @get:Rule
  val rule: ActivityTestRule<LoginActivity> = ActivityTestRule(LoginActivity::class.java)

  //Test if data binding set success texts to EditTexts
  @Test
  fun loadEditTexts() {
    val activity = rule.activity
    Assert.assertEquals("pedroSG94", activity.et_user.text.toString())
    Assert.assertEquals("MVVMExample", activity.et_password.text.toString())
  }
}