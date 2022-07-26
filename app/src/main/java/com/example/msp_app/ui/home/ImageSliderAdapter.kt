package com.example.msp_app.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.msp_app.R
import com.smarteist.autoimageslider.SliderViewAdapter

class ImageSliderAdapter(private var images: ArrayList<String>) : SliderViewAdapter<ImageSliderAdapter.Holder>() {
    override fun getCount(): Int {
        return images.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): Holder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.slider_item , parent , false)
        return Holder(view)
    }

    override fun onBindViewHolder(viewHolder: Holder?, position: Int) {
        val current = images[position]
        Glide.with(viewHolder!!.itemView).load(current).into(viewHolder.imageView)
    }

    class Holder(ItemView: View) : SliderViewAdapter.ViewHolder(ItemView) {
        var imageView: ImageView = itemView.findViewById(R.id.image_view);

    }
}