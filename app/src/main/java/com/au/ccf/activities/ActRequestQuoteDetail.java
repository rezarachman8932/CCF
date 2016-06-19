package com.au.ccf.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.au.ccf.R;

/**
 * Created by rezarachman on 6/19/16.
 */
public class ActRequestQuoteDetail extends ActBase implements View.OnClickListener {

    private String mJobType;
    private String mEquipmentType;
    private String mQuantity;
    private TextView vJobType;
    private TextView vEquipmentType;
    private Button vButtonConfirm;
    private Button vButtonEdit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_request_quote_detail);
        setHeaderTitle(getString(R.string.header_quote_request), true);
        getBundle();
        initView();
        initListener();
        setView();
    }

    private void initView() {
        vJobType = (TextView) findViewById(R.id.request_detail_job_type);
        vEquipmentType = (TextView) findViewById(R.id.request_detail_equipment_type);
        vButtonConfirm = (Button) findViewById(R.id.button_request_detail_confirm);
        vButtonEdit = (Button) findViewById(R.id.button_request_detail_edit);
    }

    private void initListener() {
        vButtonEdit.setOnClickListener(this);
        vButtonConfirm.setOnClickListener(this);
    }

    private void setView() {
        vJobType.setText(mJobType);
        vEquipmentType.setText(mEquipmentType + " - " + mQuantity + " unit(s)");
    }

    private void getBundle() {
        Bundle bundle = getIntent().getExtras();
        mJobType = bundle.getString(ActRequestQuote.JOB_TYPE);
        mEquipmentType = bundle.getString(ActRequestQuote.EQUIPMENT_TYPE);
        mQuantity = bundle.getString(ActRequestQuote.QUANTITY);
    }

    @Override
    public void onClick(View v) {

    }

}
