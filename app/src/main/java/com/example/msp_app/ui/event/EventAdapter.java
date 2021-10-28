package com.example.msp_app.ui.event;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.msp_app.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.msp_app.model.EventsModel;
import com.example.msp_app.ui.project.ProjectAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    ArrayList<EventsModel>events=new ArrayList<>();

    public ArrayList<EventsModel> getEvents() {
        return events;
    }

    private EventAdapter.OnItemClickListner mlistner;
    public interface OnItemClickListner
    {
        void OnItemClick(int position);
    }
    public  void setOnItemClickListner(EventAdapter.OnItemClickListner listner)
    {
        mlistner=listner;

    }

    public void setEvents(ArrayList<EventsModel> events) {
        this.events = events;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.event_cardview,parent,false);
        EventViewHolder viewHolder=new EventViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        String[] date=getEvents().get(position).getCreatedAt().split("T");
        holder.title.setText(getEvents().get(position).getName());
        holder.price.setText(getEvents().get(position).getFees()+" LE ");
        holder.discription.setText(getEvents().get(position).getDescription());
        holder.time.setText(date[0]);
        Picasso.get().load(getEvents().get(position).getImg()).error(R.drawable.eventlogo).into(holder.eventImage);





    }

    @Override
    public int getItemCount() {
        return getEvents().size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        ImageView eventImage;
        TextView title,discription,price,time;
        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            price=itemView.findViewById(R.id.event_price_txt);
            eventImage=itemView.findViewById(R.id.img_event);
            title=itemView.findViewById(R.id.event_name_txt);
            time=itemView.findViewById(R.id.event_time_txt);
            discription=itemView.findViewById(R.id.event_discription_txt);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mlistner!=null)
                    {
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION)
                        {
                            mlistner.OnItemClick(position);
                        }
                    }
                }
            });
        }
    }
}