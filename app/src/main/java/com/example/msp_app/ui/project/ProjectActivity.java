package com.example.msp_app.ui.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.msp_app.R;
import com.example.msp_app.model.ProjectsModel;
import com.example.msp_app.ui.home.HomeAcivity;
import com.example.msp_app.ui.main.DataViewModel;

import java.util.ArrayList;

public class ProjectActivity extends AppCompatActivity implements ProjectAdapter.OnItemClickListner {
    RecyclerView prjectRecyclerView;
    ProjectAdapter projectAdapter;
    DataViewModel dataViewModel;
    ProgressBar progressBar_project;
    ImageView projectBack;
    @Override
    public void OnItemClick(int position) {
        Intent  i=new Intent(Intent.ACTION_VIEW);
        i.setData( Uri.parse(
                (dataViewModel.projectMutableLiveData.getValue().get(position).getLink() ) ) );
        startActivity( i );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        getSupportActionBar().hide();

        projectBack=findViewById(R.id.back_project);
        prjectRecyclerView = findViewById(R.id.recproject);
        progressBar_project=findViewById(R.id.progressBar_project);
        prjectRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        dataViewModel.getProjects();
        projectAdapter = new ProjectAdapter(getApplicationContext());
        prjectRecyclerView.setAdapter(projectAdapter);
        dataViewModel.projectMutableLiveData.observe(this, new Observer<ArrayList<ProjectsModel>>() {
            @Override
            public void onChanged(ArrayList<ProjectsModel> projectsModels) {
                if(projectsModels!=null) {
                    progressBar_project.onVisibilityAggregated(false);
                }
                projectAdapter.setProjects(projectsModels);
                projectAdapter.setOnItemClickListner(ProjectActivity.this);
            }
        });

        projectBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), HomeAcivity.class);
                startActivity(i);
            }
        });

    }
}