package com.example.okhttpsample.util;

import android.util.Log;

/**
 * Created by ray on 2017/12/16.
 */

public class RayLog {
    private static final String TAG = "Raymond";
    private static boolean debug=true;
    public static void e(String msg){
        if(debug) {
            Log.e(TAG, msg);
        }
    }
}
