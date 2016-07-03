package com.au.ccf.models;

/**
 * Created by rezarachman on 7/3/16.
 */
public class BaseModel {

    private String jobType;
    private String equipmentType;
    private String quantity;
    private String quoteID;
    private String date;
    private String duration;

    public BaseModel(String jobType, String equipmentType, String quantity, String quoteID, String date, String duration) {
        this.jobType = jobType;
        this.equipmentType = equipmentType;
        this.quantity = quantity;
        this.quoteID = quoteID;
        this.date = date;
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public String getJobType() {
        return jobType;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getQuoteID() {
        return quoteID;
    }

    public String getDuration() {
        return duration;
    }

}
