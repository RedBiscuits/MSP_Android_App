package com.example.msp_app.ui.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.msp_app.R;
import com.example.msp_app.model.ProjectsModel;
import com.example.msp_app.ui.home.HomeAcivity;
import com.example.msp_app.ui.main.DataViewModel;

import java.util.ArrayList;

public class ProjectActivity extends AppCompatActivity {
   RecyclerView prjectRecyclerView;
   ProjectAdapter projectAdapter;
   DataViewModel dataViewModel;
   ImageView back;
   ProgressBar progressBar_project;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        getSupportActionBar().hide();

        progressBar_project=findViewById(R.id.progressBar_project);

        prjectRecyclerView=findViewById(R.id.recproject);
        prjectRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        dataViewModel.getProjects();
        projectAdapter=new ProjectAdapter(getApplicationContext());
        prjectRecyclerView.setAdapter(projectAdapter);


        dataViewModel.projectMutableLiveData.observe(this, new Observer<ArrayList<ProjectsModel>>() {
            @Override
            public void onChanged(ArrayList<ProjectsModel> projectsModels) {
                progressBar_project.onVisibilityAggregated(false);
               projectAdapter.setProjects(projectsModels);
            }
        });


        back=findViewById(R.id.back_project);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), HomeAcivity.class);
                startActivity(i);
            }
        });



    }
}