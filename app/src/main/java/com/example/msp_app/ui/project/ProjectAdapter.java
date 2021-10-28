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
    private OnItemClickListner mlistner;
    public interface OnItemClickListner
    {
        void OnItemClick(int position);
    }
    public  void setOnItemClickListner(OnItemClickListner listner)
    {
        mlistner=listner;

    }

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
        String[] date=projects.get(position).getCreatedAt().split("T");
        holder.ProjectName.setText(getProjects().get(position).getName());
        holder.Discrption.setText(getProjects().get(position).getTeam());
        holder.time.setText(date[0]);
        Picasso.get().load( getProjects().get( position ).getPhoto()).placeholder(R.drawable.project).into( holder.ProjectImage);


    }

    @Override
    public int getItemCount() {
        System.out.println(projects.size());
        return getProjects().size();
    }

    public class ProjectHolder  extends  RecyclerView.ViewHolder{
        TextView ProjectName,Discrption,time;
        ImageView ProjectImage;
        public ProjectHolder(@NonNull View itemView) {
            super(itemView);
            ProjectName=itemView.findViewById(R.id.ProjectName);
            Discrption=itemView.findViewById(R.id.content);
            time=itemView.findViewById(R.id.time_discription2_txt);
            ProjectImage=itemView.findViewById(R.id.Projectimage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mlistner!=null)
                    {
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION)
                        {
                            mlistner.OnItemClick(position);
                        }
                    }
                }
            });
        }
    }
}