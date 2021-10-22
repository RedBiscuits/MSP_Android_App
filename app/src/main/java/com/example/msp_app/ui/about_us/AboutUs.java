package com.example.msp_app.ui.about_us;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.msp_app.R;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        getSupportActionBar().hide();
    }
}