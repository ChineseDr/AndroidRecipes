package com.raymond.basedemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.raymond.basedemo.R;

/**
 * Created by ray on 2017/9/14.
 */

public class SecondActivity extends BaseActivity implements View.OnClickListener{
    private TextView content;
    private Button submit,reset;
    private RadioGroup sexChoose;
    private CheckBox reading,travel,food,picture,sports,movie;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();
        submit.setOnClickListener(this);
        reset.setOnClickListener(this);
    }

    private void init(){
        content=findViewById(R.id.tv);
        submit=findViewById(R.id.submmit);
        reset=findViewById(R.id.reset);
        sexChoose=findViewById(R.id.sex_chosse);
        sexChoose.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                RadioButton sexChecked=findViewById(checkedId);
                Toast.makeText(getApplicationContext(),"性别："+sexChecked.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.reset:
                break;
            case R.id.submmit:
                for(int i=0;i<sexChoose.getChildCount();i++){
                RadioButton sexChecked= (RadioButton) sexChoose.getChildAt(i);
                    if(sexChecked.isChecked()){
                        Toast.makeText(getApplicationContext(),"性别："+sexChecked.getText(),Toast.LENGTH_SHORT).show();
                    }
            }
                Intent intentThird = new Intent();
                //第一个参数包名，第二个参数要启动的activity的全路径类名
                intentThird.setClassName("com.raymond.basedemo","com.raymond.basedemo.activities.ThirdActivity");
                startActivity(intentThird);
        }
    }
}
