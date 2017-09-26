package com.raymond.basedemo.activities;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ray on 2017/9/16.
 */

public class ActivityController {
    private static List<Activity> activities=new ArrayList<Activity>();

    public static void createActivity(BaseActivity activity){
        activities.add(activity);
    }
}
