package com.ray.recyclerviewsample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ray on 2017/12/23.
 */

public class FirstAdapter extends RecyclerView.Adapter<FirstAdapter.FirstViewHolder> {
    private ArrayList<String> data;

    public FirstAdapter(ArrayList<String> data) {
        this.data = data;
    }



    @Override
    public FirstViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_first,parent,false);
        FirstViewHolder viewHolder=new FirstViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FirstViewHolder holder, int position) {
        holder.tv.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data==null?0:data.size();
    }

    public class FirstViewHolder extends RecyclerView.ViewHolder {
        private TextView tv;
        public FirstViewHolder(View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
        }
    }
}



