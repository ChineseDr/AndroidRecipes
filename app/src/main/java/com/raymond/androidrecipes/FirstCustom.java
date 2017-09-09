package com.raymond.androidrecipes;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ray on 2017/9/9.
 */

public class FirstCustom extends View {
    public FirstCustom(Context context) {
        super(context);
    }

    public FirstCustom(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FirstCustom(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public FirstCustom(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
