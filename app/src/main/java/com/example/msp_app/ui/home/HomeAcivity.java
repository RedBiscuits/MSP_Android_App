package com.example.msp_app.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.msp_app.R;
import com.example.msp_app.ui.about_us.AboutUs;
import com.example.msp_app.ui.crew.CrewAcivity;
import com.example.msp_app.ui.event.EventActivity;
import com.example.msp_app.ui.project.ProjectActivity;

public class HomeAcivity extends AppCompatActivity {
   ImageView crewBtn,eventBtn,projectBtn,aboutUsBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        crewBtn=findViewById(R.id.btn_crew);
        crewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(), CrewAcivity.class);
                startActivity(i);
            }
        });

        aboutUsBtn=findViewById(R.id.btn_about);
        aboutUsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(), AboutUs.class);
                startActivity(i);
            }
        });

        eventBtn=findViewById(R.id.btn_event);
        eventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(), EventActivity.class);
                startActivity(i);
            }
        });

        projectBtn=findViewById(R.id.btn_project);
        projectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(), ProjectActivity.class);
                startActivity(i);
            }
        });
    }

}