package com.example.msp_app.data;

import com.example.msp_app.model.CrewModel;
import com.example.msp_app.model.EventsModel;
import com.example.msp_app.model.ProjectsModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataClient {
    public static final String BASE_URL="https://mspapi.herokuapp.com/search/";
    DataInterface crewInterface;
    private static DataClient DataInstance;


    public DataClient() {
        Retrofit retrofit=new Retrofit.Builder()
                 .baseUrl(BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create()).build();

             crewInterface=retrofit.create(DataInterface.class);
    }


    public static DataClient getDataInstance() {
        if(DataInstance==null){
            DataInstance=new DataClient();

        }
        return DataInstance;
    }

    public Call<ArrayList<CrewModel>> getCrew(){
        return crewInterface.getCrowData();
    }

    public Call<ArrayList<ProjectsModel>> getProjects(){
        return crewInterface.getProjectsData();
    }
    public Call<ArrayList<EventsModel>> getEvents(){
        return crewInterface.getEventsData();
    }
}
