package com.example.msp_app.model;
import com.google.gson.annotations.SerializedName;


public class EventsModel {

    @SerializedName("id")
    private Integer id;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("topic")
    private String topic;
    @SerializedName("img")
    private String img;
    @SerializedName("name")
    private String name;
    @SerializedName("time")
    private String time;
    @SerializedName("date")
    private String date;
    @SerializedName("description")
    private String description;
    @SerializedName("fees")
    private String fees;
    @SerializedName("location")
    private String location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
