package com.example.msp_app.ui.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import com.example.msp_app.R;
import com.example.msp_app.ui.about_us.AboutUs;
import com.example.msp_app.ui.crew.CrewAcivity;
import com.example.msp_app.ui.event.EventActivity;
import com.example.msp_app.ui.project.ProjectActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeAcivity extends AppCompatActivity {
    //BottomNavigationView bottomNavigationView;
  CardView crewBtn,eventBtn,projectBtn,aboutUsBtn;
    final String faceBookUri="https://www.facebook.com/ASUTC"
            ,youtubeUri="https://www.youtube.com/channel/UCx4RR5PPCwfU_Om_9pAwaCA/featured",
            linedInUri="https://www.linkedin.com/company/msp-tech-club-asu/";

    ImageView facebookImage,youtubeImage,linkedInImage,recrute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();


        crewBtn = findViewById(R.id.card_crew);
        crewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CrewAcivity.class);
                startActivity(i);
            }
        });

        aboutUsBtn = findViewById(R.id.card_about);
        aboutUsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AboutUs.class);
                startActivity(i);
            }
        });

        eventBtn = findViewById(R.id.card_event);
        eventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), EventActivity.class);
                startActivity(i);
            }
        });

        projectBtn = findViewById(R.id.card_project);
        projectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ProjectActivity.class);
                startActivity(i);
            }
        });

         facebookImage=findViewById(R.id.bottom_facebook);
        facebookImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent faceookInIntent=new Intent(Intent.ACTION_VIEW);
                faceookInIntent.setData( Uri.parse( faceBookUri) );
                startActivity( faceookInIntent );
            }
        });
        linkedInImage=findViewById(R.id.bottom_linkedin);
        linkedInImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent linkedInIntent=new Intent(Intent.ACTION_VIEW);
                linkedInIntent.setData( Uri.parse( linedInUri) );
                startActivity( linkedInIntent );
            }
        });
         youtubeImage=findViewById(R.id.bottm_youtube);
        youtubeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent youtubeIntent=new Intent(Intent.ACTION_VIEW);
                youtubeIntent.setData( Uri.parse( youtubeUri) );
                startActivity( youtubeIntent);
            }
        });
        recrute=findViewById(R.id.bottom_recrutment_btn);
        recrute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent recrutmentInIntent = new Intent(Intent.ACTION_VIEW);
                recrutmentInIntent.setData(Uri.parse("https://reqruitment.msp-asu.me/"));
                startActivity(recrutmentInIntent);
            }
        });
       /* bottomNavigationView = findViewById(R.id.bottm_nav);
        bottomNavigationView.setBackground(null);
        bottomNavigationView.getMenu().getItem(2).setEnabled(false);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.fab:
                        break;
                    case R.id.menu_event:
                        Intent intentEvent = new Intent(getApplicationContext(), EventActivity.class);
                        startActivity(intentEvent);
                        break;
                    case R.id.menu_crew:
                        Intent intentCrew = new Intent(getApplicationContext(), CrewAcivity.class);
                        startActivity(intentCrew);
                        break;
                    case R.id.menu_recrutment:
                        Intent recrutmentInIntent = new Intent(Intent.ACTION_VIEW);
                        recrutmentInIntent.setData(Uri.parse("https://reqruitment.msp-asu.me/"));
                        startActivity(recrutmentInIntent);
                        break;
                    case R.id.menu_close:
                        finish();
                        break;
                }

                return true;
            }
        });*/

    }
    }

