package com.raymond.customview.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.raymond.customview.R;

/**
 * Created by ray on 2017/10/23.
 */

public class Drawshapes extends View {
    private Paint paint;
    public Drawshapes(Context context) {
        this(context,null);
    }

    public Drawshapes(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Drawshapes(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        paint=new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.drawColor(Color.GREEN);
        //画一个点，参数（横坐标，纵坐标，画笔）
        canvas.drawPoint(200.0f,200.0f,paint);
        //画一组点（点一对对横纵坐标的数组）
        canvas.drawPoints(new float[]{
                500,500,500,600,500,700
        },paint);
        //画一条线段（起始点的横纵坐标，结束点的横纵坐标，画笔）
        canvas.drawLine(200,100,400,200,paint);
        //画一组线段（线段端点横纵坐标的数组，画笔）
        float[] ls={200,200,400,300,200,300,400,400};
        canvas.drawLines(ls,paint);
        //



    }
}
