package com.example.csabadobai.testapi.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.csabadobai.testapi.R
import com.example.csabadobai.testapi.data.models.ActiveHuntsList
import com.example.csabadobai.testapi.data.response.ActiveHunt
import com.example.csabadobai.testapi.ui.utils.ctx
import kotlinx.android.synthetic.main.hunt_item.view.*

/**
 * Created by csaba.dobai on 18-10-2017.
 */

class HuntListAdapter(private val huntsActive: ActiveHuntsList, private val itemClick: (ActiveHunt)-> Unit) : RecyclerView.Adapter<HuntListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.hunt_item, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindHund(ActiveHunt[position])
    }

    override fun getItemCount() = huntsActive.size()

    class ViewHolder(view: View, private val itemClick: (ActiveHunt) -> Unit) : RecyclerView.ViewHolder(view){
        fun bindHund(hunt: ActiveHunt) {
            with(hunt) {
                itemView.huntNameView.text = huntName
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}