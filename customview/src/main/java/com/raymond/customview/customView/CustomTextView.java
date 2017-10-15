package com.raymond.customview.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.raymond.customview.R;

/**
 * Created by ray on 2017/10/15.
 */

public class CustomTextView extends View {
    //成员变量接受刚刚在xml中自定义的属性
    private String mTitleText;
    private int mTitleTextColor;
    private int mTitleTextSize;

    //控制绘制时范围
    private Rect mBound;
    private Paint paint;

    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray types = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTitleView, defStyleAttr, 0);
        int n = types.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = types.getIndex(i);
            switch (attr) {
                case R.styleable.CustomTitleView_titleText:
                    mTitleText = types.getString(attr);
                    break;
                case R.styleable.CustomTitleView_titleTextColor:
                    mTitleTextColor = types.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.CustomTitleView_titleTextSize:
                    mTitleTextSize = types.getDimensionPixelSize(attr,
                            (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16,
                                    getResources().getDisplayMetrics()));
            }
        }

        paint=new Paint();
        paint.setTextSize(mTitleTextSize);
        mBound=new Rect();
        paint.getTextBounds(mTitleText,0,mTitleText.length(),mBound);
    }
}
