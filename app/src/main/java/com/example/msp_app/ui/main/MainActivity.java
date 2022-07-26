package com.example.msp_app.ui.main;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.msp_app.R;
import com.example.msp_app.ui.home.HomeActivity;
import com.example.msp_app.ui.intro.IntroActivity;
import com.example.msp_app.ui.login.LoginActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();




        Thread splash = new Thread() {
            public void run() {
                try {
                    sleep(2000);

                    if(restorePrefData()) {
                        Intent i = new Intent(getApplicationContext(), HomeActivity.class);
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