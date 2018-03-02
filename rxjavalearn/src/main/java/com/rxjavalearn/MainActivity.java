package com.rxjavalearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRxJava();
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
//                if (){
                    e.onNext(1);
                    e.onNext(2);
                    e.onNext(3);
//                }
                e.onComplete();
            }
        });
        /// 被观察者创建完成

        // 二、链式调用创建观察者
        // 通过create创建被观察者对象
        Observable.create(new ObservableOnSubscribe<Integer>() {
            //在重写的subscribe方法里定义需要发送的时间
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);

                e.onComplete();
            }//一个被观察者创建完成
        }).subscribe(new Observer<Integer>() {
            //通过订阅连接被观察者和观察者 & 创建观察者 & 定义相应事件的行为
            //默认最先调用重写的onSubscribe
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("TAG","开始subscribe连接");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d("TAG","接收到事件"+integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("TAG","对Error事件做出响应");
            }

            @Override
            public void onComplete() {
                Log.d("TAG","对Complete事件做出响应");
            }
        });


        /******************************************************************************/

        //创建
    }
}
