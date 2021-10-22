package com.example.msp_app.ui.main;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.msp_app.R;
import com.example.msp_app.model.CrewModel;
import com.example.msp_app.model.EventsModel;
import com.example.msp_app.model.ProjectsModel;
import com.example.msp_app.ui.home.HomeAcivity;
import com.example.msp_app.ui.intro.IntroActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    DataViewModel dataViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);

        dataViewModel.getEvents();





        dataViewModel.projectMutableLiveData.observe(this, new Observer<ArrayList<ProjectsModel>>() {
            @Override
            public void onChanged(ArrayList<ProjectsModel> projectsModels) {
            }
        });

        dataViewModel.eventMutableLiveData.observe(this, new Observer<ArrayList<EventsModel>>() {
            @Override
            public void onChanged(ArrayList<EventsModel> eventsModels) {

            }
        });


        Thread splash = new Thread() {
            public void run() {
                try {
                    sleep(2000);

                    if(restorePrefData()) {
                        Intent i = new Intent(getApplicationContext(), HomeAcivity.class);
                        startActivity(i);
                        finish();
                    }else{
                        Intent i = new Intent(getApplicationContext(), IntroActivity.class);
                        startActivity(i);
                        finish();
                    }

                } catch (Exception e) {
                    e.getMessage();
                }
            }

        };
        splash.start();
    }

    public boolean restorePrefData() {


        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpnendBefore = pref.getBoolean("isIntroOpnend",false);
        return  isIntroActivityOpnendBefore;



    }
}