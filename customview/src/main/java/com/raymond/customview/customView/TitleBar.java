package com.raymond.customview.customView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.raymond.customview.R;

/**
 * Created by ray on 2017/11/5.
 *
 */

public class TitleBar extends RelativeLayout {
    private String mTitleText,mLeftText,mRightText;
    private int mTitleSize;
    private int mLeftTextSize;
    private int mRightTextSize;
    private int mTitleColor;
    private int mLeftColor;
    private int mRightColor;
    private Drawable mLeftBackground;
    private Drawable mRightBackground;

    private Button mLeftBtn,mRightBtn;
    private TextView mTitle;
    private OnTitleBarListener mListener;


    public TitleBar(Context context) {
        this(context,null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getAttrs(context, attrs, defStyleAttr);

    }

    private void getAttrs(Context context, AttributeSet attrs, int defStyleAttr) {
        init(context);
        TypedArray types=context.obtainStyledAttributes(attrs, R.styleable.TitleBar,defStyleAttr,0);
        int n=types.getIndexCount();
        for (int i=0;i<n;i++){
            int attr=types.getIndex(i);
            switch (attr){
                case R.styleable.TitleBar_title:
                    mTitleText =types.getString(attr);
                    break;
                case R.styleable.TitleBar_leftText:
                    mLeftText=types.getString(attr);
                    break;
                case R.styleable.TitleBar_rightText:
                    mRightText=types.getString(attr);
                    break;
                case R.styleable.TitleBar_titleTextSize:
                    mTitleSize= types.getDimensionPixelSize(attr,
                            (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,16,getResources().getDisplayMetrics()));
                    break;
                case R.styleable.TitleBar_lefTextSize:
                    mLeftTextSize=types.getDimensionPixelSize(attr,
                            (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,16,getResources().getDisplayMetrics()));
                    break;
                case R.styleable.TitleBar_rightTextSize:
                    mRightTextSize=types.getDimensionPixelSize(attr,
                            (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,16,getResources().getDisplayMetrics()));
                case R.styleable.TitleBar_titleTextColor:
                    mTitleColor=types.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.TitleBar_leftTextColor:
                    mLeftColor=types.getColor(attr,Color.BLACK);
                    break;
                case R.styleable.TitleBar_rightTextColor:
                    mRightColor=types.getColor(attr,Color.BLACK);
                    break;
                case R.styleable.TitleBar_leftBackground:
                    mLeftBackground=types.getDrawable(attr);
                    break;
                case R.styleable.TitleBar_rightBackground:
                    mRightBackground=types.getDrawable(attr);
                    break;

            }
        }
        //获取完属性调用recycle来避免重新创建是错误
        types.recycle();
    }

    private void init(Context context){
        mLeftBtn=new Button(context);
        mRightBtn=new Button(context);
        mTitle=new Button(context);
        mLeftBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.leftClick();
            }
        });

        mRightBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.righetClick();
            }
        });
    }

    public void setOnListener(OnTitleBarListener mListener) {
        this.mListener = mListener;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //使用xml文件中的值为属性赋值　
        mTitle.setText(mTitleText);
        mTitle.setTextColor(mTitleColor);
        mTitle.setTextSize(mLeftTextSize);
        mTitle.setGravity(Gravity.CENTER);

        mLeftBtn.setBackground(mLeftBackground);
        mLeftBtn.setText(mLeftText);
        mLeftBtn.setTextColor(mLeftColor);
        mLeftBtn.setTextSize(mLeftTextSize);

        mRightBtn.setBackground(mLeftBackground);
        mRightBtn.setText(mLeftText);
        mRightBtn.setTextColor(mLeftColor);
        mRightBtn.setTextSize(mLeftTextSize);

        //设置组件相对布局
        LayoutParams mLeftParams=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        //添加到View Group
        addView(mLeftBtn,mLeftParams);

        LayoutParams mRightParams=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        addView(mRightBtn,mRightParams);

        LayoutParams mTitleParams = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        addView(mTitle,mTitleParams);


    }

    //对外提供操作接口
    public interface OnTitleBarListener{
        //左组件点击事件
        void leftClick();
        //右控件点击事件
        void righetClick();
    }


}
