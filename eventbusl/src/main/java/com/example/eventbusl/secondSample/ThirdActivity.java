package com.example.eventbusl.secondSample;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.eventbusl.R;

/**
 * Created by ray on 2017/12/10.
 */

public class ThirdActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }
}
