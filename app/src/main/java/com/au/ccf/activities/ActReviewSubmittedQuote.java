package com.au.ccf.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.au.ccf.R;

/**
 * Created by rezarachman on 7/10/16.
 */
public class ActReviewSubmittedQuote extends ActBase {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_review_submitted_quote);
        setHeaderTitle(getString(R.string.header_submit_proposal), true);
    }

}
