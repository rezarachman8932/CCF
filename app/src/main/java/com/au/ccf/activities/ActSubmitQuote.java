package com.au.ccf.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.au.ccf.R;
import com.au.ccf.utils.ActivityUtil;

/**
 * Created by rezarachman on 7/5/16.
 */
public class ActSubmitQuote extends ActBase implements View.OnClickListener {

    private Button vButtonSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_submit_quote);
        setHeaderTitle(getString(R.string.header_detail_quote), true);
        initView();
        initListener();
    }

    private void initView() {
        vButtonSubmit = (Button) findViewById(R.id.button_submit_submit_detail_quote);
    }

    private void initListener() {
        vButtonSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(vButtonSubmit)) {
            ActivityUtil.startActivity(this, ActReviewSubmittedQuote.class, null, 0);
        }
    }

}
