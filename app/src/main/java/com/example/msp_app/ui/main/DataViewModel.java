package com.example.msp_app.ui.main;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.msp_app.data.DataClient;
import com.example.msp_app.model.CrewModel;
import com.example.msp_app.model.EventsModel;
import com.example.msp_app.model.ProjectsModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataViewModel extends ViewModel {
      public MutableLiveData<ArrayList<CrewModel>>crewMutableLiveData=new MutableLiveData<>();
      public MutableLiveData<ArrayList<ProjectsModel>>projectMutableLiveData=new MutableLiveData<>();
      public MutableLiveData<ArrayList<EventsModel>>eventMutableLiveData=new MutableLiveData<>();

      public void getCrew(){
            DataClient.getDataInstance().getCrew().enqueue(new Callback<ArrayList<CrewModel>>() {
                  @Override
                  public void onResponse(Call<ArrayList<CrewModel>> call, Response<ArrayList<CrewModel>> response) {
                       crewMutableLiveData.setValue(response.body());
                  }

                  @Override
                  public void onFailure(Call<ArrayList<CrewModel>> call, Throwable t) {
                  }
            });
      }

      public void getProjects(){

            DataClient.getDataInstance().getProjects().enqueue(new Callback<ArrayList<ProjectsModel>>() {
                  @Override
                  public void onResponse(Call<ArrayList<ProjectsModel>> call, Response<ArrayList<ProjectsModel>> response) {
                        projectMutableLiveData.setValue(response.body());
                  }

                  @Override
                  public void onFailure(Call<ArrayList<ProjectsModel>> call, Throwable t) {

                  }
            });

      }

      public void getEvents(){

            DataClient.getDataInstance().getEvents().enqueue(new Callback<ArrayList<EventsModel>>() {
                  @Override
                  public void onResponse(Call<ArrayList<EventsModel>> call, Response<ArrayList<EventsModel>> response) {
                      eventMutableLiveData.setValue(response.body());
                  }

                  @Override
                  public void onFailure(Call<ArrayList<EventsModel>> call, Throwable t) {

                  }
            });

      }
}
