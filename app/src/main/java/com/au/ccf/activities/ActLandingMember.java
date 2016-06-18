package com.au.ccf.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.au.ccf.R;

/**
 * Created by rezarachman on 6/18/16.
 */
public class ActLandingMember extends ActBase implements View.OnClickListener {

    private Button vRequestQuote;
    private Button vMyQuote;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_landing_member);

        setHeaderTitle(getString(R.string.header_home));
        initView();
        initListener();
    }

    private void initView() {
        vRequestQuote = (Button) findViewById(R.id.button_request_quote);
        vMyQuote = (Button) findViewById(R.id.button_my_quote);
    }

    private void initListener() {
        vRequestQuote.setOnClickListener(this);
        vMyQuote.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.equals(vRequestQuote)) {

        } else {

        }
    }

}
