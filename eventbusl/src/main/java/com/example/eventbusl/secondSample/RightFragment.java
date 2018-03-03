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
import org.greenrobot.eventbus.Subscribe;

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
        //注册订阅者
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
     * 运行中主线程，可以直接操作UI
     * @param eventMsg
     */
    public void onEventMainThread(EventMsg eventMsg){
        String context=eventMsg.getMsg()+"\n线程Name"+Thread.currentThread().getName()
                +"线程ID"+Thread.currentThread().getId();
        Log.i(TAG,"onEventMainThread(EventMsg eventMsg)接收到"+context);
    }

    @Subscribe
    public void onEventMainThread(EventMsg2 eventMsg2){
        String context=eventMsg2.getMsg()+"\n线程Name"+Thread.currentThread().getName()
                +"线程ID"+Thread.currentThread().getId();
        Log.i(TAG,"onEventMainThread(EventMsg eventMsg)接收到"+context);
    }

    /**
     * 在新的线程中执行，如果事件消息是主线程post出来的
     * 此方法会开启一个新的线程来处理事件
     * 适用于多个线程的任务组，内部采用线程池管理
     * 与发布者无关，总是创建一个新的线程
     * @param eventMsg
     */
    @Subscribe
    public void onEventAsync(EventMsg eventMsg){
        String context=eventMsg.getMsg()+"\n线程Name"+Thread.currentThread().getName()
                +"线程ID"+Thread.currentThread().getId();
        Log.i(TAG,"onEventAsync(EventMsg eventMsg)接收到"+context);
    }

    /**
     * 在子线程中执行
     * 如果是发布者在子线程中，直接执行
     * 如果不在子线程中，则创建一个新的线程来执行处理
     * @param eventMsg
     */
    @Subscribe
    public void onEventBackgroundThread(EventMsg eventMsg){
        String context=eventMsg.getMsg()+"\n线程Name"+Thread.currentThread().getName()
                +"线程ID"+Thread.currentThread().getId();
        Log.i(TAG,"onEventBackgroundThread(EventMsg eventMsg)接收到"+context);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //注销订阅者
        EventBus.getDefault().unregister(this);
    }
}
