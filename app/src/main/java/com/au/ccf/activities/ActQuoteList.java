package com.au.ccf.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.Toast;

import com.au.ccf.R;
import com.au.ccf.adapters.QuoteAdapter;
import com.au.ccf.models.Quote;

import java.util.ArrayList;
import java.util.List;

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
        populateDataList();
    }

    private void initView() {
        vInputSearchQuote = (EditText) findViewById(R.id.input_search_quote);

        vQuoteList = (RecyclerView) findViewById(R.id.quote_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        vQuoteList.setLayoutManager(layoutManager);
    }

    private List<Quote> getQuotes() {
        List<Quote> quotes = new ArrayList<>();
        quotes.add(new Quote("Behalf", "2", "33", "05.29", "5 days", "OK"));
        quotes.add(new Quote("Awesome", "1", "34", "01.29", "1 days", "OK"));
        quotes.add(new Quote("Dirty", "6", "31", "05.26", "3 days", "OK"));
        quotes.add(new Quote("Wages", "45", "35", "06.29", "2 days", "OK"));
        quotes.add(new Quote("And", "7", "22", "05.09", "7 days", "OK"));
        quotes.add(new Quote("Car", "4", "66", "03.29", "1 days", "OK"));
        return quotes;
    }

    private void populateDataList() {
        final List<Quote> quotes = getQuotes();
        if (quotes == null || quotes.size() <= 0) {
            return;
        }
        QuoteAdapter adapter = new QuoteAdapter(quotes);
        adapter.setOnItemClickListener(new QuoteAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(QuoteAdapter.QuoteHolder item, int position) {
                Quote quote = quotes.get(position);
                Toast.makeText(ActQuoteList.this, quote.getJobEquipment(), Toast.LENGTH_SHORT).show();
            }
        });
        vQuoteList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
