package com.ray.recyclerviewsample;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.*;
import android.support.v7.widget.DividerItemDecoration;

import java.util.ArrayList;

/**
 * Created by ray on 2017/12/23.
 */

public class FirstActivity extends Activity {
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initView();
    }

    public void initView(){
        recyclerView=findViewById(R.id.recycler);

        RecyclerView.LayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        FirstAdapter adapter=new FirstAdapter(initData());
        android.support.v7.widget.DividerItemDecoration itemDecoration=
                new DividerItemDecoration(this,LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(itemDecoration);
    }

    public ArrayList<String> initData(){
        ArrayList<String> data=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            data.add("Item:"+i+1);
        }
        return data;
    }
}
