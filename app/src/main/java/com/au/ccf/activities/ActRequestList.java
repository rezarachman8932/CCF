package com.au.ccf.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.au.ccf.R;
import com.au.ccf.adapters.DefaultListAdapter;
import com.au.ccf.models.Request;
import com.au.ccf.utils.ActivityUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rezarachman on 7/3/16.
 */
public class ActRequestList extends ActBase {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_default_list);
        setHeaderTitle(getString(R.string.button_search_request).toUpperCase(), true);
        initViews();
        populateDataList();
    }

    private List<Request> getRequests() {
        List<Request> quotes = new ArrayList<>();
        quotes.add(new Request("Employee", "Brake", "13", "332", "14 March 2015", "5 days", "London"));
        quotes.add(new Request("Driver", "Gun", "19", "345", "11 April 2015", "3 days", "Roma"));
        quotes.add(new Request("Runner", "Spoon", "32", "354", "23 June 2015", "2 days", "Lisbon"));
        return quotes;
    }

    private void populateDataList() {
        final List<Request> requests = getRequests();
        if (requests == null || requests.size() <= 0) {
            return;
        }
        DefaultListAdapter adapter = new DefaultListAdapter(this, requests);
        adapter.setOnItemClickListener(new DefaultListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DefaultListAdapter.DefaultHolder item, int position) {
                ActivityUtil.startActivity(ActRequestList.this, ActFilterQuotes.class, null, 0);
            }
        });
        vQuoteList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
