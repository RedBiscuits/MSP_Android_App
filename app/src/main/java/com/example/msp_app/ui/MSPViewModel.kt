package com.example.msp_app.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.msp_app.R
import com.example.msp_app.data.DataClient
import com.example.msp_app.model.EventModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.E

class MSPViewModel :ViewModel(){

    private val committeesMutableLiveData : MutableLiveData<ArrayList<String>>by lazy {
        MutableLiveData()
    }
    fun getCommittees(){
        val arr:ArrayList<String> = ArrayList()
        val url = "https://images.unsplash.com/photo-1453728013993-6d66e9c9123a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80"
        arr.add(url)
        arr.add(url)
        arr.add(url)
        arr.add(url)
        arr.add(url)
        arr.add(url)
        arr.add(url)
        committeesMutableLiveData.postValue(arr)
    }

    val trendsMutableLiveData : MutableLiveData<ArrayList<String>>by lazy {
        MutableLiveData()
    }
    fun getTrends(){
        val arr:ArrayList<String> = ArrayList()
        val url = "https://images.unsplash.com/photo-1453728013993-6d66e9c9123a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80"
        arr.add(url)
        arr.add(url)
        arr.add(url)
        trendsMutableLiveData.postValue(arr)
    }

    val animationsMutableLiveData : MutableLiveData<ArrayList<Int>>by lazy {
        MutableLiveData()
    }
    fun getAnimations(){
        val arr:ArrayList<Int> = ArrayList()
        val url = R.raw.settings_white
        arr.add(url)
        arr.add(url)
        arr.add(url)
        arr.add(url)
        arr.add(url)
        arr.add(url)
        arr.add(url)
        animationsMutableLiveData.value = arr
    }
    val eventsMutableLiveData : MutableLiveData<ArrayList<EventModel>>by lazy {
        MutableLiveData()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun getEvents(){
       /* DataClient.getDataInstance().events.enqueue(object :
            Callback<ArrayList<EventModel>> {
            override fun onResponse(call: Call<ArrayList<EventModel>>,
                                    response: Response<ArrayList<EventModel>>
            ) {
                println("Respoooooooooooooooooonse " + response.body())
                eventsMutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<ArrayList<EventModel>>, t: Throwable) {
                println(t.toString())
            }
        })*/
        val response = ArrayList<EventModel>()
        response.add(EventModel(name = "Cyber Security Summer Training" ,
            image_url = "https://scontent-ams2-1.xx.fbcdn.net/v/t39.30808-6/296151604_4843838775716666_5877312237398276274_n.jpg?stp=dst-jpg_p526x395&_nc_cat=100&ccb=1-7&_nc_sid=340051&_nc_eui2=AeGlydgfch_iTodjLh4KAiNNGiprn3DuX7waKmufcO5fvB8chQvL8K-2HMouNqMf_1aif3h34fCvR5rHQLtjS0aI&_nc_ohc=U1NZRZd-JokAX89BHqx&_nc_ht=scontent-ams2-1.xx&oh=00_AT9Z4q-97UU0DbCn6iFgtZo8IWN1QCzzQCjPLv38VZikgw&oe=632B45C3"
            , startDate = Date(DateTimeFormatter.ISO_INSTANT.format(Instant.now()))))
        response.add(EventModel(name = "Bit by Bit" ,
            image_url =  "https://scontent-ams4-1.xx.fbcdn.net/v/t39.30808-6/279623666_4603558863077993_5844481756406215555_n.jpg?stp=dst-jpg_p526x395&_nc_cat=103&ccb=1-7&_nc_sid=340051&_nc_eui2=AeHKjq1RhgFvegKwpav9bWsrdb-8ZGd7Q2p1v7xkZ3tDaniloZZnbi6eGSnXzyc6KKPiQR_oJHnu8MCXgTZg-MQF&_nc_ohc=WBhMPxd6rlwAX_tS6t7&tn=5kLIOH8iL0OAbu4K&_nc_ht=scontent-ams4-1.xx&oh=00_AT_YoERXLIqNNRFi_B1BbC2OCk8gEjKl_n5cExsDKeqTXw&oe=632A539B"
            , startDate = Date(DateTimeFormatter.ISO_INSTANT.format(Instant.now()))))
        response.add(EventModel(name = "ASU Employment fair" ,
            image_url = "https://scontent-ams4-1.xx.fbcdn.net/v/t39.30808-6/274778080_4631951560247311_8769695676402677361_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=730e14&_nc_eui2=AeG31HY7FULJq_r9BCHThTSo2THKUZm8GyTZMcpRmbwbJBOd_VJ6H4bZALTTaTNHjuMq-g4oTXmzKaBPTGxaiMU4&_nc_ohc=tXxA0ZcrQzkAX-tHluG&_nc_ht=scontent-ams4-1.xx&oh=00_AT-_oM28xSZZCbej9tgSCbW-Om0HVCAm1MDTqzLgRk3gGA&oe=632BB6A3"
            , startDate = Date(DateTimeFormatter.ISO_INSTANT.format(Instant.now()))))
        response.add(EventModel(name = "Closing" ,
            image_url = "https://scontent-ams2-1.xx.fbcdn.net/v/t39.30808-6/244590480_1800063906848437_5990557649191009609_n.jpg?stp=dst-jpg_p600x600&_nc_cat=111&ccb=1-7&_nc_sid=b9115d&_nc_eui2=AeF-0uVFrMXD2n4--_VYAQf_JTlPXoQnHKklOU9ehCccqQRog-pkhrQnsRNuxAnKQvnyezu0397b9ashaj6vuh49&_nc_ohc=sSVFpjYVoMMAX9p-Ymd&_nc_ht=scontent-ams2-1.xx&oh=00_AT-2WVQiqJF3JxBPzm0AnD0IjcJa2aYWEud98kX9ogQgLg&oe=632B3AE6"
            , startDate = Date(DateTimeFormatter.ISO_INSTANT.format(Instant.now()))))
        eventsMutableLiveData.value =response
    }
}