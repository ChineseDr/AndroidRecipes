package com.raymond.basedemo.views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raymond.basedemo.model.Contact;

import java.util.List;

/**
 * Created by ray on 2017/10/24.
 */

public class MyContactAdapter extends RecyclerView.Adapter {
    private List<Contact> contacts;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view= LayoutInflater.from(parent.getContext()).inflate();
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
