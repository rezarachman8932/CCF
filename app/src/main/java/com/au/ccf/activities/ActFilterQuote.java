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
public class ActFilterQuote extends ActBase implements View.OnClickListener {

    private Button vButtonConfirm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_filter_quote);
        setHeaderTitle(getString(R.string.header_filter_quote), true);
        initView();
        initListener();
    }

    private void initView() {
        vButtonConfirm = (Button) findViewById(R.id.button_filter_confirm);
    }

    private void initListener() {
        vButtonConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ActivityUtil.startActivity(ActFilterQuote.this, ActSubmitQuote.class, null, 0);
    }

}
