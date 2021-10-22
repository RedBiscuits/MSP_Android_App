package com.example.msp_app.ui.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.msp_app.R;
import com.example.msp_app.model.ProjectsModel;
import com.example.msp_app.ui.main.DataViewModel;

import java.util.ArrayList;

public class ProjectActivity extends AppCompatActivity {
   RecyclerView prjectRecyclerView;
   ProjectAdapter projectAdapter;
   DataViewModel dataViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        prjectRecyclerView=findViewById(R.id.recproject);

        prjectRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        dataViewModel.getProjects();
        projectAdapter=new ProjectAdapter(getApplicationContext());
        prjectRecyclerView.setAdapter(projectAdapter);
        dataViewModel.projectMutableLiveData.observe(this, new Observer<ArrayList<ProjectsModel>>() {
            @Override
            public void onChanged(ArrayList<ProjectsModel> projectsModels) {
               projectAdapter.setProjects(projectsModels);
            }
        });






    }
}