package com.example.eventbusl.secondSample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.eventbusl.R;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by ray on 2017/12/10.
 */

public class RightFragment extends Fragment {
    private final String TAG = "RightFragment";
    private TextView tvRF;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_right,null);
        tvRF=view.findViewById(R.id.tv_fr);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EventBus.getDefault().register(this);
    }

    //发送消息和接收线程在同一个线程中
    public void onEvent(EventMsg eventMsg){
        String context=eventMsg.getMsg()+"\n线程Name"+Thread.currentThread().getName()
                        +"线程ID"+Thread.currentThread().getId();
        Log.i(TAG,"onEvent(EventMsg eventMsg)接收到"+context);
    }

    public void onEvent(EventMsg2 eventMsg2){
        String context=eventMsg2.getMsg()+"\n线程Name"+Thread.currentThread().getName()
                +"线程ID"+Thread.currentThread().getId();
        Log.i(TAG,"onEvent(EventMsg eventMsg2)接收到"+context);
    }

    /**
     * 运行中主线程，可以直接操作UI线程
     * @param eventMsg
     */
    public void onEventMainThread(EventMsg eventMsg){
        String context=eventMsg.getMsg()+"\n线程Name"+Thread.currentThread().getName()
                +"线程ID"+Thread.currentThread().getId();
        Log.i(TAG,"onEvent(EventMsg eventMsg)接收到"+context);
    }

    public void onEventMainThread(EventMsg2 eventMsg2){
        String context=eventMsg2.getMsg()+"\n线程Name"+Thread.currentThread().getName()
                +"线程ID"+Thread.currentThread().getId();
        Log.i(TAG,"onEvent(EventMsg eventMsg)接收到"+context);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
