package com.example.msp_app.ui.crew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.msp_app.R;
import com.example.msp_app.model.CrewModel;
import com.example.msp_app.ui.home.HomeActivity;
import com.example.msp_app.ui.main.DataViewModel;

import java.util.ArrayList;

public class CrewAcivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CrewAdapter crewAdapter;
    private LayoutAnimationController controller;
    private Context context;
    ImageView back;
    DataViewModel dataViewModel;
    ProgressBar crewProgress;
     String filterString;
    Button android,flutter,web,machine,game,dataScience,cyber,hr,pr,media,highBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crew);
        getSupportActionBar().hide();

        crewProgress=findViewById(R.id.progressBar_crew);

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        dataViewModel.getCrew();

        crewAdapter=new CrewAdapter(getApplicationContext());


        dataViewModel.crewMutableLiveData.observe(this, new Observer<ArrayList<CrewModel>>() {
            @Override
            public void onChanged(ArrayList<CrewModel> crewModels) {
                if(crewModels!=null){
                    crewProgress.setVisibility(View.GONE);
                    crewAdapter.setMembersList(crewModels);

                }

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


        back=findViewById(R.id.back_crew);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(i);
            }
        });

        android=findViewById(R.id.crew_android);
        android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterString="android";
                crewAdapter.getFilter().filter(filterString);
            }
        });
        flutter=findViewById(R.id.crew_flutter);
        flutter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterString="flutter";
                crewAdapter.getFilter().filter(filterString);
            }
        });
        web=findViewById(R.id.crew_web);
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterString="web";
                crewAdapter.getFilter().filter(filterString);
            }
        });
        game=findViewById(R.id.crew_game);
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterString="game";
                crewAdapter.getFilter().filter(filterString);
            }
        });
        dataScience=findViewById(R.id.crew_data_science);
        dataScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterString="data Science";
                crewAdapter.getFilter().filter(filterString);
            }
        });

        cyber=findViewById(R.id.crew_cyber);
        cyber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterString="cyber";
                crewAdapter.getFilter().filter(filterString);
            }
        });
        machine=findViewById(R.id.crew_machine);
        machine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterString="machine Learning";
                crewAdapter.getFilter().filter(filterString);
            }
        });

        media=findViewById(R.id.crew_media);
        media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterString="media";
                crewAdapter.getFilter().filter(filterString);
            }
        });

        hr=findViewById(R.id.crew_hr);
        hr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterString="hr";
                crewAdapter.getFilter().filter(filterString);
            }
        });
        pr=findViewById(R.id.crew_pr);
        pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterString="pr";
                crewAdapter.getFilter().filter(filterString);
            }
        });
        highBoard=findViewById(R.id.crew_high_board);
        highBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterString="highboard";
                crewAdapter.getFilter().filter(filterString);
            }
        });

    }
}