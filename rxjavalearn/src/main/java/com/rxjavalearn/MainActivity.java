package com.rxjavalearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void initRxJava(){
        // 一、普通创建方式
        // 创建被观察者Observable对象，传入参数OnSubscribe对象
        // 当Observable被订阅时，OnSubscribe的call方法会被调用，
        // 即事件序列会按照设定依次被触发
        // 即观察者会依次调用对应事件的重写方法来响应事件
        // 观察者模式：被观察者向观察者传递对象 & 被观察者调用观察者的回调方法
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            // 通过ObservableEmitter对象产生和传递对象
            // ObservableEmitter类
            // a.定义：事件发射器
            // b.作用：1.定义需要发送的时间； 2.向观察者发送事件
            // c.备注：发送时间前检查观察者的isUNsubscribe状态，以便没有观察者的时间，让Observable停止发射数据
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onComplete();
            }
        });
        /// 被观察者创建完成

        // 二、链式调用创建观察者
        // 通过create创建


        /******************************************************************************/

        //创建
    }
}
