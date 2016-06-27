package com.au.ccf.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.au.ccf.R;

/**
 * Created by rezarachman on 6/26/16.
 */
public class ActQuoteList extends ActBase {

    private EditText vInputSearchQuote;
    private RecyclerView vQuoteList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_quote_list);
        setHeaderTitle(getString(R.string.button_my_quote).toUpperCase(), true);

        initView();
    }

    private void initView() {
        vInputSearchQuote = (EditText) findViewById(R.id.input_search_quote);

        vQuoteList = (RecyclerView) findViewById(R.id.quote_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        vQuoteList.setLayoutManager(layoutManager);
    }

    private void populateDataList() {

    }

}
