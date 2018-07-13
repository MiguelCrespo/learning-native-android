package com.example.miguel.test

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MainAdapter : RecyclerView.Adapter<CustomViewHolder>() {
    override fun getItemCount(): Int {
        return 5
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
    val layoutInflater = LayoutInflater.from(p0.context)
        val cellFromRow = layoutInflater.inflate(R.layout.main_card, p0, false)

        return CustomViewHolder(cellFromRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

    }
}

class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {

}