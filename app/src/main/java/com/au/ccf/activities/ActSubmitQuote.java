package com.au.ccf.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.au.ccf.R;

/**
 * Created by rezarachman on 7/5/16.
 */
public class ActSubmitQuote extends ActBase {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_submit_quote);
        setHeaderTitle(getString(R.string.header_detail_quote), true);
    }

}
