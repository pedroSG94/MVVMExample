package com.pedro.avengersmvvm.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.pedro.avengersmvvm.R
import com.pedro.avengersmvvm.base.BaseActivity
import com.pedro.avengersmvvm.base.BaseViewModel
import com.pedro.avengersmvvm.databinding.ActivityLoginBinding
import com.pedro.avengersmvvm.viewmodel.UserViewModel

class LoginActivity : BaseActivity() {

  private lateinit var userViewModel: UserViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)
    val binding: ActivityLoginBinding =
        DataBindingUtil.setContentView(this, R.layout.activity_login)
    binding.user = userViewModel
  }

  override fun onResume() {
    super.onResume()
    userViewModel.checkLogged()
  }

  override fun loadViewModel(): List<BaseViewModel> {
    userViewModel = UserViewModel(this)
    return arrayListOf(userViewModel)
  }
}
