package com.raymond.basedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.raymond.basedemo.activities.FirstActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_start,btn_start_other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start= (Button) findViewById(R.id.start_btn);
        btn_start_other= (Button) findViewById(R.id.start_other_acti);
        btn_start.setOnClickListener(this);
        btn_start_other.setOnClickListener(this);
        getComponentName();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_btn:
                Log.d("MainActivity","pre start FirstActivity");
                Intent intentLauncher=new Intent(MainActivity.this, FirstActivity.class);
                startActivity(intentLauncher);
                break;
            //通过组件名启动组件，构造组件第一个参数包名，第二个参数组件名全路径
            case R.id.start_other_acti:
                Intent intent=new Intent();
                ComponentName componentName=new ComponentName("com.raymond.basedemo","com.raymond.lonely.SingleActivity");
                intent.setComponent(componentName);
                startActivity(intent);
            default:
                break;
        }
    }
}
