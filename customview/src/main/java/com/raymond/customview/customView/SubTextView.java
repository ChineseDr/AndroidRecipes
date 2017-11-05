package com.raymond.customview.customView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by ray on 2017/11/5.
 * 自定义控件实现方式1：拓展原生控件，重写onDraw()方法实现拓展，如果保留原生控件的实现调用
 * super.onDraw()
 * 例子：SubTextView继承TextView实现拓展在绘制的文字上添加一个横线
 */


@SuppressLint("AppCompatCustomView")
public class SubTextView extends TextView {
    public final static String TAG="SubTextView";
    private Paint mPaint;
    public SubTextView(Context context) {
        super(context);
    }

    public SubTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SubTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /*
     * 继承自原生控件
     *
     */
    @Override
    protected void onDraw(Canvas canvas) {
        Log.d(TAG,"onDraw()");
        mPaint=new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(2);
        super.onDraw(canvas);
        canvas.drawLine(0,getMeasuredHeight()/2,getMeasuredWidth(),getMeasuredHeight()/2,mPaint);

    }


}
