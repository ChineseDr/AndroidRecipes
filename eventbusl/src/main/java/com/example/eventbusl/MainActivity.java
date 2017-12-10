package com.example.eventbusl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.eventbusl.secondSample.ThirdActivity;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
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
    public void onEventMainThread(MyMessage event){
        String msg= "返回的数据" + event.getMsg();
        tvM.setText(msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonM:
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
                break;
            case R.id.btn_ss:
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
