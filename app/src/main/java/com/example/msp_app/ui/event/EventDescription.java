package com.example.msp_app.ui.event;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.msp_app.R;
import com.example.msp_app.model.EventsModel;
import com.example.msp_app.ui.home.HomeAcivity;

import java.util.ArrayList;

public class EventDescription extends AppCompatActivity {
    Intent eventData;
    TextView tobic,time,disc,fees;
    ImageView eventImage,back;
    ArrayList<EventsModel>events=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_description);

        tobic=findViewById(R.id.event_tobic_desc);
        time=findViewById(R.id.event_time_disc);
        disc=findViewById(R.id.event_discription_desc);
        fees=findViewById(R.id.event_fees_desc);
        eventImage=findViewById(R.id.img_event_disc);

        eventData=getIntent();
        //events= eventData.getExtras().getParcelableArrayList("event");


        back=findViewById(R.id.back_disc);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),EventActivity.class);
                startActivity(i);
            }
        });

    }
}