package com.example.msp_app.ui.event;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.msp_app.R;
import com.example.msp_app.model.EventsModel;
import com.example.msp_app.model.ProjectsModel;
import com.example.msp_app.ui.home.HomeAcivity;
import com.example.msp_app.ui.main.DataViewModel;
import com.example.msp_app.ui.project.ProjectAdapter;

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity {
    RecyclerView eventRecyclerView;
    EventAdapter eventAdapter;
    DataViewModel dataViewModel;
    Intent transferEventDataIntent;
    ImageView back;
    ProgressBar progressBar_event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        getSupportActionBar().hide();

        progressBar_event=findViewById(R.id.progressBar_event);

        transferEventDataIntent=new Intent();

        eventRecyclerView=findViewById(R.id.recycle_view_events);
        eventRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        dataViewModel.getEvents();

        eventAdapter=new EventAdapter();
        eventRecyclerView.setAdapter(eventAdapter);
        dataViewModel.eventMutableLiveData.observe(this, new Observer<ArrayList<EventsModel>>() {
            @Override
            public void onChanged(ArrayList<EventsModel> eventsModels) {
                progressBar_event.onVisibilityAggregated(false);
                eventAdapter.setEvents(eventsModels);
                transferEventDataIntent.putExtra("event",eventsModels);
            }
        });

        back=findViewById(R.id.back_event);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), HomeAcivity.class);
                startActivity(i);
            }
        });

    }
}