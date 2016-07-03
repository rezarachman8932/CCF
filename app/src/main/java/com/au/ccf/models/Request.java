package com.au.ccf.models;

/**
 * Created by rezarachman on 7/3/16.
 */
public class Request extends BaseModel {

    public String getLocation() {
        return location;
    }

    private String location;

    public Request(String jobType, String equipmentType, String quantity, String quoteID, String date, String duration, String location) {
        super(jobType, equipmentType, quantity, quoteID, date, duration);
        this.location = location;
    }

    public Request(String jobType, String equipmentType, String quantity, String quoteID, String date, String duration) {
        super(jobType, equipmentType, quantity, quoteID, date, duration);
    }

}
