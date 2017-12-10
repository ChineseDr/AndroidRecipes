package com.example.eventbusl;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by ray on 2017/12/10.
 */

public class SecondActivity extends Activity implements View.OnClickListener {
    private Button btnS;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }

    @Override
    public void onClick(View v) {
        EventBus.getDefault().post(new MyMessage("事件：SencondActivity SecondBtn 被点击了"));
    }
}
