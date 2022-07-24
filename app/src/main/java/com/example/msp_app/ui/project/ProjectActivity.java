package com.example.msp_app.ui.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.example.msp_app.R;
import com.example.msp_app.model.ProjectsModel;
import com.example.msp_app.ui.home.HomeActivity;
import com.example.msp_app.ui.main.DataViewModel;

import java.util.ArrayList;

public class ProjectActivity extends AppCompatActivity implements ProjectAdapter.OnItemClickListner {
    RecyclerView prjectRecyclerView;
    ProjectAdapter projectAdapter;
    DataViewModel dataViewModel;
    ProgressBar progressBar_project;
    ImageView projectBack;
    String filterString;
    Button android,flutter,web,machine,game,dataScience,cyber;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.bottom_nav,menu);
        MenuItem serchItem=menu.findItem(R.id.action_Search);
        SearchView searchView= (SearchView) serchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                return false;
            }
        });

        return true;
    }

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
                    progressBar_project.setVisibility(View.GONE);
                }
                projectAdapter.setProjects(projectsModels);
                projectAdapter.setOnItemClickListner(ProjectActivity.this);
            }
        });

        projectBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(i);
            }
        });


    android=findViewById(R.id.android);
    android.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            filterString="android";
            projectAdapter.getFilter().filter(filterString);
        }
    });
        flutter=findViewById(R.id.flutter);
        flutter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterString="flutter";
                projectAdapter.getFilter().filter(filterString);
            }
        });
        web=findViewById(R.id.web);
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterString="web";
                projectAdapter.getFilter().filter(filterString);
            }
        });
        game=findViewById(R.id.game);
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterString="game";
                projectAdapter.getFilter().filter(filterString);
            }
        });
        dataScience=findViewById(R.id.data_science);
        dataScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterString="data Science";
                projectAdapter.getFilter().filter(filterString);
            }
        });

        cyber=findViewById(R.id.cyber);
        cyber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterString="cyber";
                projectAdapter.getFilter().filter(filterString);
            }
        });
        machine=findViewById(R.id.machine);
        machine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterString="machine Learning";
                projectAdapter.getFilter().filter(filterString);
            }
        });





    }
}