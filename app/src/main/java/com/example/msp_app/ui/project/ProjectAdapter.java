package com.example.msp_app.ui.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.msp_app.R;
import com.example.msp_app.model.ProjectsModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectHolder> {
    private ArrayList<ProjectsModel>projects=new ArrayList<ProjectsModel>();
    Context context;


    public ProjectAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<ProjectsModel> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<ProjectsModel> projects) {
        this.projects = projects;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public ProjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View Projects_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_cardview,parent,false);
        ProjectHolder holder=new ProjectHolder(Projects_view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectHolder holder, int position) {
          holder.ProjectName.setText(getProjects().get(position).getName());
          holder.Discrption.setText(getProjects().get(position).getDescription());

              Picasso.get().load( getProjects().get( position ).getPhoto()).placeholder(R.drawable.recyshape2).into( holder.ProjectImage);
              if(holder.ProjectImage==null) {
                  holder.ProjectImage.setImageResource(R.drawable.recyshape2);
              }


    }

    @Override
    public int getItemCount() {
        System.out.println(projects.size());
        return getProjects().size();
    }

    public class ProjectHolder  extends  RecyclerView.ViewHolder{
        TextView ProjectName,Discrption;
        ImageView ProjectImage;
        public ProjectHolder(@NonNull View itemView) {
            super(itemView);
            ProjectName=itemView.findViewById(R.id.ProjectName);
            Discrption=itemView.findViewById(R.id.content);
            ProjectImage=itemView.findViewById(R.id.Projectimage);

        }
    }
}

