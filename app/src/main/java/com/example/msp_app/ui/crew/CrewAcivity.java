package com.example.msp_app.ui.crew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.msp_app.R;
import com.example.msp_app.model.CrewModel;
import com.example.msp_app.ui.main.DataViewModel;

import java.util.ArrayList;

public class CrewAcivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CrewAdapter crewAdapter;
    private LayoutAnimationController controller;
    private Context context;
    DataViewModel dataViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crew);
        getSupportActionBar().hide();

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        dataViewModel.getCrew();

        crewAdapter=new CrewAdapter(getApplicationContext());
        dataViewModel.crewMutableLiveData.observe(this, new Observer<ArrayList<CrewModel>>() {
            @Override
            public void onChanged(ArrayList<CrewModel> crewModels) {

                crewAdapter.setMembersList(crewModels);
            }
        });

        recyclerView=findViewById(R.id.recycle_view_crew);

        recyclerView.setAdapter(crewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setFocusable(false);
        recyclerView.setNestedScrollingEnabled(false);
        controller=null;
        context=recyclerView.getContext();
        controller= AnimationUtils.loadLayoutAnimation(context,R.anim.layout_animation_fail_down);
        recyclerView.setLayoutAnimation(controller);
        recyclerView.scheduleLayoutAnimation();
    }
}