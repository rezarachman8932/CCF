package com.au.ccf.models;

/**
 * Created by rezarachman on 7/2/16.
 */
public class Quote {

    private String jobEquipment;
    private String quantity;
    private String quoteID;
    private String time;
    private String duration;
    private String proposalStatus;

    public Quote(String jobEquipment, String quantity, String quoteID, String time, String duration, String proposalStatus) {
        this.jobEquipment = jobEquipment;
        this.quantity = quantity;
        this.quoteID = quoteID;
        this.time = time;
        this.duration = duration;
        this.proposalStatus = proposalStatus;
    }

    public String getJobEquipment() {
        return jobEquipment;
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

    public String getDuration() {
        return duration;
    }

    public String getProposalStatus() {
        return proposalStatus;
    }

}
