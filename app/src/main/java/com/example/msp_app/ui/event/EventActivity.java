package com.example.msp_app.ui.event;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.msp_app.R;
import com.example.msp_app.model.EventsModel;
import com.example.msp_app.model.ProjectsModel;
import com.example.msp_app.ui.main.DataViewModel;
import com.example.msp_app.ui.project.ProjectAdapter;

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity {
    RecyclerView eventRecyclerView;
    EventAdapter eventAdapter;
    DataViewModel dataViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        getSupportActionBar().hide();



        eventRecyclerView=findViewById(R.id.recycle_view_events);

        eventRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        dataViewModel.getEvents();
        eventAdapter=new EventAdapter();
        eventRecyclerView.setAdapter(eventAdapter);
        dataViewModel.eventMutableLiveData.observe(this, new Observer<ArrayList<EventsModel>>() {
            @Override
            public void onChanged(ArrayList<EventsModel> eventsModels) {
                eventAdapter.setEvents(eventsModels);
            }
        });



    }
}