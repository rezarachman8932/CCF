package com.au.ccf.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.au.ccf.R;

import java.util.List;

/**
 * Created by rezarachman8932 on 6/10/16.
 */
public class RoleAdapter extends RecyclerView.Adapter<RoleAdapter.RoleHolder> {

    private List<String> roles;
    private OnItemClickListener onItemClickListener;

    public RoleAdapter(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public RoleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_role, parent, false);
        return new RoleHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(RoleHolder holder, int position) {
        holder.bind(roles.get(position));
    }

    @Override
    public int getItemCount() {
        return roles.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(RoleHolder item, int position);
    }

    public static class RoleHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private RoleAdapter adapter;
        TextView textRole;

        public RoleHolder(View itemView, RoleAdapter adapter) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.adapter = adapter;

            textRole = (TextView) itemView.findViewById(R.id.item_text_role);
        }

        public void bind(String item) {
            textRole.setText(item);
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
