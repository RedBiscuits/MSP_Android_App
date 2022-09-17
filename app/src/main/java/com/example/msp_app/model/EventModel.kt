package com.example.msp_app.model

import android.view.inspector.InspectionCompanion
import com.google.gson.annotations.SerializedName
import java.util.*
import kotlin.collections.ArrayList

data class EventModel(
    @SerializedName("name")   val name: String,
    @SerializedName("startDate")   val startDate: Date,
    @SerializedName("image_url")   val image_url: String,
    @SerializedName("_id")   val _id : String = "",
    @SerializedName("description")   val description: String = "",
    @SerializedName("type")   val type: String= "",
    @SerializedName("duration")   val duration: String= "",
    @SerializedName("endDate")   val endDate: Date = Date(),
    @SerializedName("eventStatus")   val eventStatus: String= "",
    @SerializedName("event_creator_id")   val event_creator_id: String= "",
    @SerializedName("isAccessibleForFree")   val isAccessibleForFree: Boolean = true,
    @SerializedName("inLanguage")   val inLanguage: String= "",
    @SerializedName("event_location")   val event_location: String= "",
    @SerializedName("maximumPhysicalAttendeeCapacity")   val maximumPhysicalAttendeeCapacity: Int=8,
    @SerializedName("maximumVirtualAttendeeCapacity")   val maximumVirtualAttendeeCapacity: Int =9,
    @SerializedName("performer")   val performer: ArrayList<String> = ArrayList<String>(),
    @SerializedName("created_at")   val created_at: Date = Date(),
    @SerializedName("__v")   val __v : Int =0
)
