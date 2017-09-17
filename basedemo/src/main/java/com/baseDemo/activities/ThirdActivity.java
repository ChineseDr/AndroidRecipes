package com.baseDemo.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.raymond.basedemo.R;

/**
 * Created by ray on 2017/9/14.
 */

public class ThirdActivity extends BaseActivity implements OnClickListener{
    private TextView content;
    private Button btn_back,btn_next;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        init();
        btn_back.setOnClickListener(this);
        btn_next.setOnClickListener(this);
    }

    private void init(){
        content = findViewById(R.id.tv);
        btn_back=findViewById(R.id.back);
        btn_next=findViewById(R.id.next);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back:
                break;
            case R.id.next:
                break;
            default:
                break;
        }
    }
}
