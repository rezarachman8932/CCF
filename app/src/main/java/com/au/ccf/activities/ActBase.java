package com.au.ccf.activities;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.au.ccf.R;

/**
 * Created by rezarachman8932 on 5/28/16.
 */
public abstract class ActBase extends AppCompatActivity {

    protected final String DATA_DETAIL_QUANTITY       = "quantity";
    protected final String DATA_DETAIL_EQUIPMENT_TYPE = "equipment_type";
    protected final String DATA_DETAIL_JOB_TYPE       = "job_type";
    protected final String DATA_DETAIL_QUOTE_ID       = "quote_id";

    protected EditText vInputSearchQuote;
    protected RecyclerView vQuoteList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    protected void initViews() {
        vInputSearchQuote = (EditText) findViewById(R.id.input_search_keyword);
        vQuoteList = (RecyclerView) findViewById(R.id.default_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        vQuoteList.setLayoutManager(layoutManager);
    }

    protected void setHeaderTitle(String title, boolean isBackButton) {
        if (getSupportActionBar() != null) {
            LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.header, null);

            ActionBar.LayoutParams params = new ActionBar.LayoutParams(
                    ActionBar.LayoutParams.WRAP_CONTENT,
                    ActionBar.LayoutParams.MATCH_PARENT,
                    Gravity.CENTER);

            TextView titleText = (TextView) view.findViewById(R.id.header_title);
            titleText.setText(title);

            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(view, params);
            getSupportActionBar().setDisplayHomeAsUpEnabled(isBackButton);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
