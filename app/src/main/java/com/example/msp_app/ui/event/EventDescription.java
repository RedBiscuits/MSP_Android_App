package com.example.msp_app.ui.event;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.msp_app.R;
import com.squareup.picasso.Picasso;

public class EventDescription extends AppCompatActivity {
    Intent eventData;
    TextView tobic,time,disc,fees,location;
    ImageView eventImage,back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_description);
      getSupportActionBar().hide();
        tobic=findViewById(R.id.event_tobic_desc);
        time=findViewById(R.id.event_time_disc);
        disc=findViewById(R.id.event_discription_desc);
        fees=findViewById(R.id.event_fees_desc);
        eventImage=findViewById(R.id.img_event_disc);
        location=findViewById(R.id.event_location_disc);

         eventData=getIntent();
         Bundle b=eventData.getExtras();
        //events= eventData.getExtras().getParcelableArrayList("event");
          if(b!=null) {
              Picasso.get().load(b.get("img").toString()).into(eventImage);
              tobic.setText(" "+b.get("tobic").toString());

              String[] date = b.get("time").toString().split("T");
              time.setText(date[0]);
              disc.setText(" "+b.get("disc").toString());
              location.setText(" "+b.get("location").toString());
              fees.setText(b.get("fees").toString() + "LE");
          }
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