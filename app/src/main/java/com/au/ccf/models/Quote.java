package com.au.ccf.models;

/**
 * Created by rezarachman on 7/2/16.
 */
public class Quote extends BaseModel {

    private String proposalStatus;

    public Quote(String jobType, String equipmentType, String quantity, String quoteID, String date, String duration, String proposalStatus) {
        super(jobType, equipmentType, quantity, quoteID, date, duration);
        this.proposalStatus = proposalStatus;
    }

    public Quote(String jobType, String equipmentType, String quantity, String quoteID, String date, String duration) {
        super(jobType, equipmentType, quantity, quoteID, date, duration);
    }

    public String getProposalStatus() {
        return proposalStatus;
    }

}
