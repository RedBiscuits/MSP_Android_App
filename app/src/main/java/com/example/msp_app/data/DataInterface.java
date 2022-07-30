package com.example.msp_app.data;

import com.example.msp_app.model.CrewModel;
import com.example.msp_app.model.EventModel;
import com.example.msp_app.model.EventsModel;
import com.example.msp_app.model.ProjectsModel;
import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DataInterface {
    @GET("crow")
    public Call<ArrayList<CrewModel>>getCrowData();
    @GET("project")
    public Call<ArrayList<ProjectsModel>>getProjectsData();
    @GET("event")
    public Call<ArrayList<EventModel>>getEventsData();
    @POST
    Call<EventModel>postEvent(EventModel event);
}
