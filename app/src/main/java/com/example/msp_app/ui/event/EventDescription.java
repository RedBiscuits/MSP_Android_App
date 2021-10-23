package com.example.msp_app.ui.event;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.msp_app.R;

public class EventDescription extends AppCompatActivity {
    Intent eventData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_description);

        eventData.getData();

    }
}