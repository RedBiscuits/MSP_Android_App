package com.example.msp_app.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.example.msp_app.ui.home.SpareListAdapter.TrendingViewHolder
import com.example.msp_app.model.Events_Model
import com.bumptech.glide.request.RequestOptions
import com.example.msp_app.R
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import android.widget.TextView
import java.util.ArrayList

class SpareListAdapter : RecyclerView.Adapter<TrendingViewHolder>() {
    private var events_list = ArrayList<Events_Model>()
    private var options = RequestOptions()
        .centerCrop()
        .placeholder(R.mipmap.ic_launcher_round)
        .error(R.mipmap.ic_launcher_round)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingViewHolder {
        return TrendingViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.spare_item_card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {
        holder.eventDate.text = events_list[position].eventDate
        holder.eventDescription.text = events_list[position].eventDescription
        Glide.with(holder.itemView).load(events_list[position].imageUrl)
            .apply(options).into(holder.eventImage)
    }

    override fun getItemCount(): Int {
        return events_list.size
    }

    fun setEventsList(eventsList: ArrayList<Events_Model>) {
        this.events_list = eventsList
        notifyDataSetChanged()
    }

    inner class TrendingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var eventDate: TextView
        var eventDescription: TextView
        var eventImage: ImageView

        init {
            eventDate = itemView.findViewById(R.id.trending_RV_date_TV)
            eventDescription = itemView.findViewById(R.id.trending_RV_description_TV)
            eventImage = itemView.findViewById(R.id.trending_RV_IV)
        }
    }
}