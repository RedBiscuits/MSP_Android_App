package com.example.msp_app.ui.event;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.msp_app.R;
import com.example.msp_app.model.EventsModel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    ArrayList<EventsModel>events=new ArrayList<>();

    public ArrayList<EventsModel> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<EventsModel> events) {
        this.events = events;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EventAdapter.EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.event_cardview,parent,false);
        EventViewHolder viewHolder=new EventViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.EventViewHolder holder, int position) {
        holder.title.setText(getEvents().get(position).getName());
        holder.discription.setText(getEvents().get(position).getDescription());
        Picasso.get().load(getEvents().get(position).getImg()).into(holder.eventImage);

        if(holder.eventImage.getDrawable()==null){
            holder.eventImage.setImageResource(R.drawable.recyshape2);
        }


    }

    @Override
    public int getItemCount() {
        return getEvents().size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        ImageView eventImage;
        TextView title,discription;
        public EventViewHolder(@NonNull View itemView) {
            super(itemView);

            eventImage=itemView.findViewById(R.id.img_event);
            title=itemView.findViewById(R.id.event_name_txt);
            discription=itemView.findViewById(R.id.event_discription_txt);
        }
    }
}
