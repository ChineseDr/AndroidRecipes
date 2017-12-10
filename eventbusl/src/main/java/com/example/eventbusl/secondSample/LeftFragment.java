package com.example.eventbusl.secondSample;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by ray on 2017/12/10.
 */

public class LeftFragment extends ListFragment {
    private final String TAG="LeftFragment";

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] strs={"主线程事件消息1","子线程事件消息1","主线程事件消息2"};
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,strs));

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        switch (position){
            case 0:
                //主线程发送消息
                Log.i(TAG,">>>主线程发出的事件消息1:线程名字"+Thread.currentThread().getName()+"线程ID"+Thread.currentThread().getId());
                EventBus.getDefault().post(new EventMsg("主线程发送的事件消息1"));
                break;
            case 1:
                //子线程发送消息
                new Thread(){
                    @Override
                    public void run() {
                        Log.i(TAG,">>>子线程发送的消息1:线程Name"+Thread.currentThread().getName()+"线程ID"+Thread.currentThread().getId());
                        EventBus.getDefault().post(new EventMsg("子线程发送的事件消息1"));
                    }
                }.start();
                break;
            case 2:
                //主线程发送事件消息2
                Log.i(TAG,">>>主线程发出的事件消息2:线程名字"+Thread.currentThread().getName()+"线程ID"+Thread.currentThread().getId());
                EventBus.getDefault().post(new EventMsg2("主线程发送的事件消息1"));
                break;
            default:

                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
