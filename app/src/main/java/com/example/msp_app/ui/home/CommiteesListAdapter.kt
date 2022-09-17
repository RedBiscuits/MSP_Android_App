package com.example.msp_app.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.msp_app.R
import com.example.msp_app.ui.home.CommiteesListAdapter.TrendingViewHolder
import com.google.android.material.imageview.ShapeableImageView


class CommiteesListAdapter : RecyclerView.Adapter<TrendingViewHolder>() {
    private var animationList:ArrayList<Int> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingViewHolder {
        return TrendingViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.commitees_item_card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {

        if(position !=1) {
            holder.shapeableImageView.setImageResource(R.drawable.android)
        }
    }

    override fun getItemCount(): Int {
        return animationList.size
    }

    fun setAnimationList(eventsList: ArrayList<Int>) {
        this.animationList = eventsList
        notifyDataSetChanged()
    }

    inner class TrendingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var shapeableImageView:ShapeableImageView

        init {
            shapeableImageView= itemView.findViewById(R.id.committee_image)
        }
    }
}