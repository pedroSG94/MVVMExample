package com.pedro.mvvmexample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pedro.mvvmexample.databinding.ActivityMainBinding
import com.pedro.mvvmexample.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

  private lateinit var viewModel: UserViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    viewModel = UserViewModel(this)
    binding.viewModel = viewModel
  }
}
