package com.example.msp_app.ui.event

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.msp_app.R
import com.example.msp_app.model.EventModel
import com.smarteist.autoimageslider.SliderViewAdapter
import java.net.URI
import java.util.ArrayList

class EventAdapter(private var events: ArrayList<EventModel>?)
    : SliderViewAdapter<EventAdapter.ViewHolder>() {
    class ViewHolder (ItemView: View) : SliderViewAdapter.ViewHolder(ItemView){
        var img: ImageView = itemView.findViewById(R.id.event_img)
        var title: TextView = itemView.findViewById(R.id.event_tv)
        var date: TextView = itemView.findViewById(R.id.event_date)
    }

    override fun getCount(): Int {
        return events?.size ?: 0
    }
    fun setData(events: ArrayList<EventModel>?){
        this.events = events
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.event_item , parent , false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, position: Int) {
        val current = events?.get(position)
        viewHolder?.title?.text = current?.name
        viewHolder?.date?.text = current?.startDate.toString()
        if (viewHolder != null && current?.image_url != null) {
            Glide.with(viewHolder.itemView).load(current.image_url).into(viewHolder.img)
        }
    }
}