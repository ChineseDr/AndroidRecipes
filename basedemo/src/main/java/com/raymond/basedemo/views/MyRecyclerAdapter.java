package com.raymond.basedemo.views;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.raymond.basedemo.model.Contact;

import java.util.List;

/**
 * Created by ray on 2017/10/24.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter {
    private List<Contact> contacts;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
