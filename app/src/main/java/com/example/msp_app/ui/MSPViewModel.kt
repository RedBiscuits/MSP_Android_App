package com.example.msp_app.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MSPViewModel :ViewModel(){

    val committeesMutableLiveData : MutableLiveData<ArrayList<String>>by lazy {
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
        committeesMutableLiveData.value = arr
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
        arr.add(url)
        arr.add(url)
        arr.add(url)
        arr.add(url)
        trendsMutableLiveData.value = arr
    }

}