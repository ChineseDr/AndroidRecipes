package com.raymond.androidrecipes;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by ray on 2017/9/9.
 */

public class SecondCustom extends ViewGroup {
    public SecondCustom(Context context) {
        super(context);
    }

    public SecondCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SecondCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SecondCustom(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
