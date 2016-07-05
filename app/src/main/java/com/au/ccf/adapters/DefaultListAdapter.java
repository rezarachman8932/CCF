package com.au.ccf.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.au.ccf.R;
import com.au.ccf.models.BaseModel;
import com.au.ccf.models.Quote;
import com.au.ccf.models.Request;

import java.util.List;

/**
 * Created by rezarachman on 6/26/16.
 */
public class DefaultListAdapter extends RecyclerView.Adapter<DefaultListAdapter.DefaultHolder> {

    private OnItemClickListener onItemClickListener;
    private Context mContext;
    private List<? extends BaseModel> mBaseModels;

    public DefaultListAdapter(Context context, List<? extends BaseModel> baseModels) {
        mBaseModels = baseModels;
        mContext = context;
    }

    @Override
    public DefaultHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_default_list, parent, false);
        return new DefaultHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(DefaultHolder holder, int position) {
        if (mBaseModels.get(position) instanceof Quote) {
            Quote quote = (Quote) mBaseModels.get(position);
            holder.textDuration.setText(quote.getDuration());
            holder.textQuoteId.setText(mContext.getString(R.string.label_quote_id).concat(" ").concat(quote.getQuoteID()));
            holder.textEquipmentQuantity.setText(quote.getJobType());
            holder.textStatusAndLocation.setText(quote.getProposalStatus());
            holder.textStatusAndLocation.setTextColor(mContext.getResources().getColor(android.R.color.holo_red_dark));
            if (position % 2 == 0) {
                holder.backgroundLayout.setBackgroundColor(mContext.getResources().getColor(R.color.colorBackgroundItemFirst));
            } else {
                holder.backgroundLayout.setBackgroundColor(mContext.getResources().getColor(R.color.colorBackgroundItemSecond));
            }
        } else {
            Request request = (Request) mBaseModels.get(position);
            holder.textDuration.setText(request.getDuration());
            holder.textQuoteId.setText(mContext.getString(R.string.label_quote_id).concat(" ").concat(request.getQuoteID()));
            holder.textEquipmentQuantity.setText(request.getJobType());
            holder.textStatusAndLocation.setText(request.getLocation());
            holder.textStatusAndLocation.setTextColor(mContext.getResources().getColor(android.R.color.black));
            if (position % 2 == 0) {
                holder.backgroundLayout.setBackgroundColor(mContext.getResources().getColor(R.color.colorBackgroundItemFirst));
            } else {
                holder.backgroundLayout.setBackgroundColor(mContext.getResources().getColor(R.color.colorBackgroundItemSecond));
            }
        }
    }

    @Override
    public int getItemCount() {
        return mBaseModels.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(DefaultHolder item, int position);
    }

    public static class DefaultHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private DefaultListAdapter adapter;
        private TextView textEquipmentQuantity;
        private TextView textQuoteId;
        private TextView textDuration;
        private TextView textStatusAndLocation;
        private RelativeLayout backgroundLayout;

        public DefaultHolder(View itemView, DefaultListAdapter adapter) {
            super(itemView);
            this.adapter = adapter;
            textEquipmentQuantity = (TextView) itemView.findViewById(R.id.job_equipment_quantity);
            textQuoteId = (TextView) itemView.findViewById(R.id.quote_id);
            textDuration = (TextView) itemView.findViewById(R.id.quote_time_duration);
            textStatusAndLocation = (TextView) itemView.findViewById(R.id.proposal_status_and_time_duration);
            backgroundLayout = (RelativeLayout) itemView.findViewById(R.id.row_background);
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
