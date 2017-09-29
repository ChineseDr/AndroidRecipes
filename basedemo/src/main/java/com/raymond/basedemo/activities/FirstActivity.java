package com.raymond.basedemo.activities;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.raymond.basedemo.R;


/**
 * Created by ray on 2017/9/14.
 */

public class FirstActivity extends BaseActivity implements View.OnClickListener{
    private final String TAG = "FirstActivity";
    private TextView content;
    private Button btn_back,btn_next;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        init();
        btn_back.setOnClickListener(this);
        btn_next.setOnClickListener(this);
    }

    private void init(){
        content=findViewById(R.id.tv);
        btn_back=findViewById(R.id.back);
        btn_next=findViewById(R.id.next);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                break;
            case R.id.next:
                Intent intentSecond = new Intent();
                intentSecond.setClass(FirstActivity.this,SecondActivity.class);
                startActivity(intentSecond);
                break;
            default:
                break;
        }
    }
}
