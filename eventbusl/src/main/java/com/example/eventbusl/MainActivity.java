package com.example.eventbusl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.eventbusl.secondSample.ThirdActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivity";
    private Button btnM;
    private TextView tvM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        EventBus.getDefault().register(this);
    }

    private void init(){
        btnM=findViewById(R.id.buttonM);
        tvM=findViewById(R.id.textViewM);
        btnM.setOnClickListener(this);
    }

    /**
     *
     * @param event:需要传递的数据
     */
    @Subscribe
    public void onEventMainThread(MyMessage event){
        String msg= "返回的数据" + event.getMsg();
        tvM.setText(msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonM:
                Log.i(TAG,"StartActivity Second");
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
                break;
            case R.id.btn_ss:
                Log.i(TAG,"StartActivity Third");
                startActivity(new Intent(MainActivity.this, ThirdActivity.class));
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
