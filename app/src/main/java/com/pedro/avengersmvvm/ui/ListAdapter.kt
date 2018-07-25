package com.pedro.avengersmvvm.ui

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.pedro.avengersmvvm.R
import com.pedro.avengersmvvm.databinding.ListItemBinding
import com.pedro.avengersmvvm.retrofit.Avenger

class ListAdapter(private var avengerList: MutableList<Avenger> = ArrayList()) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val inflater: LayoutInflater = LayoutInflater.from(parent.context)
    val binding: ListItemBinding =
        DataBindingUtil.inflate(inflater, R.layout.list_item, parent, false)
    return ViewHolder(binding)
  }

  override fun getItemCount(): Int = avengerList.size

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.binding.avenger = avengerList[position]
  }

  fun addItems(avengersList: List<Avenger>) {
    this.avengerList.clear()
    this.avengerList.addAll(avengersList)
    notifyDataSetChanged()
  }

  class ViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)
}