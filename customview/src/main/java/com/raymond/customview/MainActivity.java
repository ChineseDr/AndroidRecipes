package com.raymond.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.raymond.customview.base.Drawshapes;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(new Drawshapes(this));
    }
}
