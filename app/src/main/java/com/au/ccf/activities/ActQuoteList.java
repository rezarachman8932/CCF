package com.au.ccf.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.au.ccf.R;
import com.au.ccf.adapters.DefaultListAdapter;
import com.au.ccf.models.Quote;
import com.au.ccf.utils.ActivityUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rezarachman on 6/26/16.
 */
public class ActQuoteList extends ActBase {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_default_list);
        setHeaderTitle(getString(R.string.button_my_quote).toUpperCase(), true);
        initViews();
        populateDataList();
    }

    private List<Quote> getQuotes() {
        List<Quote> quotes = new ArrayList<>();
        quotes.add(new Quote("Employee", "2", "134", "June 2014", "2 Days", "DONE", "Brake"));
        quotes.add(new Quote("Driver", "1", "139", "July 2014", "4 Days", "DONE", "Hand"));
        quotes.add(new Quote("Runner", "5", "132", "April 2014", "5 Days", "DONE", "Tools"));
        return quotes;
    }

    private void populateDataList() {
        final List<Quote> quotes = getQuotes();
        if (quotes == null || quotes.size() <= 0) {
            return;
        }
        DefaultListAdapter adapter = new DefaultListAdapter(this, quotes);
        adapter.setOnItemClickListener(new DefaultListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DefaultListAdapter.DefaultHolder item, int position) {
                Quote quote = quotes.get(position);
                Bundle bundle = new Bundle();
                bundle.putString(DATA_DETAIL_EQUIPMENT_TYPE, quote.getEquipmentType());
                bundle.putString(DATA_DETAIL_JOB_TYPE, quote.getJobType());
                bundle.putString(DATA_DETAIL_QUANTITY, quote.getQuantity());
                bundle.putString(DATA_DETAIL_QUOTE_ID, quote.getQuoteID());
                ActivityUtil.startActivity(ActQuoteList.this, ActDetailQuote.class, bundle, 0);
            }
        });
        vQuoteList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
