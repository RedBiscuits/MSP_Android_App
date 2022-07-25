package com.example.msp_app.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.msp_app.R
import com.smarteist.autoimageslider.SliderViewAdapter

class ImageSliderAdapter(private var images: ArrayList<Int>) : SliderViewAdapter<ImageSliderAdapter.Holder>() {
    override fun getCount(): Int {
        return images.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): Holder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.slider_item , parent , false)
        return Holder(view)
    }

    override fun onBindViewHolder(viewHolder: Holder?, position: Int) {
        val current = images[position]
        viewHolder!!.image_view.setImageResource(current)
        Log.d("meow" , current.toString())

    }

    class Holder(ItemView: View) : SliderViewAdapter.ViewHolder(ItemView) {
        lateinit var image_view: ImageView;

        init {
            image_view =  itemView.findViewById(R.id.image_view)
        }

    }
}