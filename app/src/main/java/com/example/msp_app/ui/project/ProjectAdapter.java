package com.example.msp_app.ui.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.msp_app.R;
import com.example.msp_app.model.ProjectsModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectHolder> implements Filterable {
    private List<ProjectsModel>projects=new ArrayList<ProjectsModel>();
    private List<ProjectsModel>projectsModelsFull;
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

    public List<ProjectsModel> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectsModel> projects) {
        this.projects = projects;
        this.projectsModelsFull=new ArrayList<>(projects);
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
        ProgressBar progressBar;
        public ProjectHolder(@NonNull View itemView) {
            super(itemView);
            ProjectName=itemView.findViewById(R.id.ProjectName);
            Discrption=itemView.findViewById(R.id.content);
            time=itemView.findViewById(R.id.time_discription2_txt);
            ProjectImage=itemView.findViewById(R.id.Projectimage);
            progressBar=itemView.findViewById(R.id.progressBar_project);
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
    @Override
    public Filter getFilter() {
        return projectFilter;
    }

    private Filter projectFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<ProjectsModel>filteredList=new ArrayList<>();

            if(charSequence==null || charSequence.length()==0){
                filteredList.addAll(projectsModelsFull);
                Toast.makeText(context,"No Project yet",Toast.LENGTH_LONG).show();
            }else{
                String filterPattern= charSequence.toString().toLowerCase().trim();
                for(ProjectsModel item:projectsModelsFull){
                    if(item.getTeam().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results=new FilterResults();
            results.values=filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                             projects.clear();
                             projects.addAll((List) filterResults.values);
                             notifyDataSetChanged();

        }
    };
}