package com.au.ccf.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.au.ccf.R;
import com.au.ccf.models.Quote;

import java.util.List;

/**
 * Created by rezarachman on 6/26/16.
 */
public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.QuoteHolder> {

    private OnItemClickListener onItemClickListener;
    private List<Quote> quotes;

    public QuoteAdapter(List<Quote> quotes) {
        this.quotes = quotes;
    }

    @Override
    public QuoteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_quote, parent, false);
        return new QuoteHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(QuoteHolder holder, int position) {
        Quote quote = quotes.get(position);
        holder.textDuration.setText(quote.getDuration());
        holder.textQuoteId.setText(quote.getQuoteID());
        holder.textEquipmentQuantity.setText(quote.getJobEquipment());
        holder.textStatus.setText(quote.getProposalStatus());
    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(QuoteHolder item, int position);
    }

    public static class QuoteHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private QuoteAdapter adapter;
        private TextView textEquipmentQuantity;
        private TextView textQuoteId;
        private TextView textDuration;
        private TextView textStatus;

        public QuoteHolder(View itemView, QuoteAdapter adapter) {
            super(itemView);
            this.adapter = adapter;
            textEquipmentQuantity = (TextView) itemView.findViewById(R.id.job_equipment_quantity);
            textQuoteId = (TextView) itemView.findViewById(R.id.quote_id);
            textDuration = (TextView) itemView.findViewById(R.id.quote_time_duration);
            textStatus = (TextView) itemView.findViewById(R.id.proposal_status);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            final OnItemClickListener listener = adapter.getOnItemClickListener();
            if (listener != null) {
                listener.onItemClick(this, getAdapterPosition());
            }
        }
    }

}
