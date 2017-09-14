package com.baseDemo.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.raymond.basedemo.R;

/**
 * Created by ray on 2017/9/14.
 */

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}
