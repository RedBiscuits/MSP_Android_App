package com.example.msp_app.model

import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

data class EventModel(

    @SerializedName("_id")   val _id : String,
    @SerializedName("name")   val name: String,
    @SerializedName("description")   val description: String,
    @SerializedName("type")   val type: String,
    @SerializedName("duration")   val duration: String,
    @SerializedName("startDate")   val startDate: Date,
    @SerializedName("endDate")   val endDate: Date,
    @SerializedName("eventStatus")   val eventStatus: String,
    @SerializedName("event_creator_id")   val event_creator_id: String,
    @SerializedName("image_url")   val image_url: String,
    @SerializedName("isAccessibleForFree")   val isAccessibleForFree: Boolean,
    @SerializedName("inLanguage")   val inLanguage: String,
    @SerializedName("event_location")   val event_location: String,
    @SerializedName("maximumPhysicalAttendeeCapacity")   val maximumPhysicalAttendeeCapacity: Int,
    @SerializedName("maximumVirtualAttendeeCapacity")   val maximumVirtualAttendeeCapacity: Int,
    @SerializedName("performer")   val performer: ArrayList<String>,
    @SerializedName("created_at")   val created_at: Date,
    @SerializedName("__v")   val __v : Int
)
