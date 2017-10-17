package com.raymond.customview.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
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
        this(context,null);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //TypedArray是工具类，通过context.obtainStyledAttributes把属性注册进去
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

    //测量控件大小，
    //当我们设置明确的宽度和高度时，系统帮我们测量的结果就是我们设置的结果，
    //系统帮我们测量的高度和宽度都是match_parent，不论我们设置为wrap_content还是match_parent
    //系统帮测量的结果都是match_parent的长度,因此当我们需要设置控件大小为wrap_content时我们要重写onMeasure
    //MeasureSpec的specMode,一共三种类型：
    //EXACTLY：一般是设置了明确的值或者是match_paren
    //AT_MOST：表示子布局限制在一个最大值内，一般为wrap_content
    //UNSPECIFIED：表示子布局想要多大就多大
    //widthMeasureSpec 和 heightMeasureSpec 是int值，但他不是宽和高，而是由宽（高
    //和各自对应方向上的测量模式组合的值（测量模式是二进制常量00,01,10
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
       //取出宽度的测量模式
        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
        //取出宽度的确切数值
        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
        //获取height的specMode和值
        int heightMode=MeasureSpec.getMode(heightMeasureSpec);
        int heightSize=MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        if(widthMode==MeasureSpec.EXACTLY){
            width=widthSize;
        }else {
            paint.setTextSize(mTitleTextSize);
            paint.getTextBounds(mTitleText,0,mTitleText.length(),mBound);
            float textWidth=mBound.width();
            int desired= (int) (getPaddingLeft()+textWidth+getPaddingRight());
            width=desired;
        }

        if (heightMode==MeasureSpec.EXACTLY){
            height=heightSize;
        }else{
            paint.setTextSize(mTitleTextSize);
            paint.getTextBounds(mTitleText,0,mTitleText.length(),mBound);
            float textHeight=mBound.height();
            int desired= (int) (getPaddingTop()+textHeight+getPaddingBottom());
            height=desired;
        }
    //如果对View的宽高进行修改了，不要调用 super.onMeasure( widthMeasureSpec, heightMeasureSpec); 
        //要调用 setMeasuredDimension( widthsize, heightsize); 这个函数。
        setMeasuredDimension(width,height);
    }

    //绘制控件，canvas:画布(可以理解为系统给我们的一块内存区域，并且提供了一系列对这块区域进行操作的方法API);
    //paint：画布上笔（颜色，画刷～）
    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
//      设置画笔颜色
        paint.setColor(0xff0000);

        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),paint);
        paint.setColor(mTitleTextColor);
        canvas.drawText(mTitleText,getWidth()/2-mBound.width()/2,getHeight()/2+mBound.height()/2,paint);

    }
}
