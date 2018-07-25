package com.pedro.avengersmvvm.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.pedro.avengersmvvm.R
import com.pedro.avengersmvvm.base.BaseActivity
import com.pedro.avengersmvvm.base.BaseViewModel
import com.pedro.avengersmvvm.databinding.ActivityListBinding
import com.pedro.avengersmvvm.retrofit.Avenger
import com.pedro.avengersmvvm.viewmodel.RequestViewModel
import com.pedro.avengersmvvm.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_list.*
import java.util.*


class ListActivity : BaseActivity() {

  private lateinit var userViewModel: UserViewModel
  private lateinit var requestViewModel: RequestViewModel

  enum class Filter {
    ALL, ACTIVE, INACTIVE
  }

  private var filter = Filter.ALL
  private var avengersList: List<Avenger> = Collections.emptyList()
  private val adapter = ListAdapter()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding: ActivityListBinding = DataBindingUtil.setContentView(this, R.layout.activity_list)
    binding.user = userViewModel
    binding.request = requestViewModel
    loadSpinner()
    initRecycler()
  }

  override fun loadViewModel(): List<BaseViewModel> {
    userViewModel = UserViewModel(this)
    requestViewModel = RequestViewModel(this)
    return arrayListOf(userViewModel, requestViewModel)
  }

  private fun loadSpinner() {
    val spinnerValues =
        arrayOf(Filter.values()[0].name, Filter.values()[1].name, Filter.values()[2].name)
    val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerValues)
    spinner.adapter = adapter
    spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
      override fun onNothingSelected(p0: AdapterView<*>?) {

      }

      override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        filter = Filter.values()[spinner.selectedItemPosition]
        loadAvengers()
      }

    }
  }

  private fun initRecycler() {
    recycler.adapter = adapter
    recycler.layoutManager = LinearLayoutManager(this@ListActivity)
    requestViewModel.loadList(object : RequestViewModel.Callback {
      override fun onLoadList(avengersList: List<Avenger>) {
        this@ListActivity.avengersList = avengersList
        loadAvengers()
      }
    })
  }

  private fun loadAvengers() {
    val mutableList: MutableList<Avenger> = avengersList.toMutableList()
    if (filter != Filter.ALL) {
      avengersList.forEach {
        if (filter == Filter.ACTIVE && !it.active) {
          mutableList.remove(it)
        } else if (filter == Filter.INACTIVE && it.active) {
          mutableList.remove(it)
        }
      }
    }
    adapter.addItems(mutableList)
  }
}
