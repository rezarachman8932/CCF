package com.au.ccf.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.au.ccf.R;
import com.au.ccf.utils.ActivityUtil;

/**
 * Created by rezarachman on 6/18/16.
 */
public class ActLandingProvider extends ActBase implements View.OnClickListener {

    private Button vSearchRequest;
    private Button vMyProposal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_landing_provider);
        setHeaderTitle(getString(R.string.header_home), false);
        initView();
        initListener();
    }

    private void initView() {
        vSearchRequest = (Button) findViewById(R.id.button_search_request);
        vMyProposal = (Button) findViewById(R.id.button_my_proposals);
    }

    private void initListener() {
        vSearchRequest.setOnClickListener(this);
        vMyProposal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(vSearchRequest)) {
            ActivityUtil.startActivity(this, ActRequestList.class, null, 0);
        } else {

        }
    }

}
