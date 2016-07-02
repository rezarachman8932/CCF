package com.au.ccf.models;

/**
 * Created by rezarachman on 7/2/16.
 */
public class Quote {

    private String jobType;
    private String equipmentType;
    private String quantity;
    private String quoteID;
    private String time;
    private String duration;
    private String proposalStatus;

    public Quote(String jobType, String quantity, String quoteID, String time, String duration, String proposalStatus, String equipmentType) {
        this.jobType = jobType;
        this.quantity = quantity;
        this.quoteID = quoteID;
        this.time = time;
        this.duration = duration;
        this.proposalStatus = proposalStatus;
        this.equipmentType = equipmentType;
    }

    public String getJobType() {
        return jobType;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getQuoteID() {
        return quoteID;
    }

    public String getTime() {
        return time;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public String getDuration() {
        return duration;
    }

    public String getProposalStatus() {
        return proposalStatus;
    }

}
