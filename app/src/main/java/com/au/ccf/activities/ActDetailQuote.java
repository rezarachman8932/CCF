package com.au.ccf.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.au.ccf.R;

/**
 * Created by rezarachman on 7/2/16.
 */
public class ActDetailQuote extends ActBase {

    private String mQuoteID;
    private String mEquipmentType;
    private String mJobType;
    private String mQuantity;

    private TextView vTextQuoteID;
    private TextView vTextJobType;
    private TextView vTextQuantityEquipmentType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_detail_quote);
        setHeaderTitle(getString(R.string.header_detail_quote), true);
        getDataDetail();
        initView();
        setData();
    }

    private void initView() {
        vTextQuantityEquipmentType = (TextView) findViewById(R.id.text_detail_quantity_equipment_type);
        vTextJobType = (TextView) findViewById(R.id.text_detail_job_type);
        vTextQuoteID = (TextView) findViewById(R.id.text_detail_quote_id);
    }

    private void setData() {
        String unit = "unit";
        int quantity = Integer.valueOf(mQuantity);
        if (quantity > 1) {
            unit = "units";
        }
        vTextQuoteID.setText(getString(R.string.label_quote_id).concat(mQuoteID));
        vTextJobType.setText(mJobType);
        vTextQuantityEquipmentType.setText(mEquipmentType
                .concat(" - ")
                .concat(mQuantity)
                .concat(" ")
                .concat(unit));
    }

    private void getDataDetail() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mQuoteID = bundle.getString(DATA_DETAIL_QUOTE_ID);
            mEquipmentType = bundle.getString(DATA_DETAIL_EQUIPMENT_TYPE);
            mJobType = bundle.getString(DATA_DETAIL_JOB_TYPE);
            mQuantity = bundle.getString(DATA_DETAIL_QUANTITY);
        }
    }

}
