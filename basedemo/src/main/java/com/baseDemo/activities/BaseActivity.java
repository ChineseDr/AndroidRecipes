package com.baseDemo.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by ray on 2017/9/16.
 */

public class BaseActivity extends Activity {
    private String TAG;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TAG=getClass().toString();
        Log.d(TAG,"onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

}
