package com.rxjavalearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    public static final String TAG="MainActivity";

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

    }

    /**
     * 快速创建 & 发送事件
     */
    public void quickCreate(){
        //一、just()
        //a.作用：快速创建一个被观察者对象（Observable） &
        //  发送事件特点：直接发送传入的事件，可以发送10条以下事件

        //b.具体使用
        //  1.创建时传入泛型（整型1，2,3,4）在创建后发送这些对象，相当于onNext()
        Observable.just(1,2,3,4)
                //至此被观察者对象Observable创建完成
                //2.通过订阅（subscribe）连接被观察者和观察者
                //创建观察者 & 定义响应事件的行为
                .subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


        //二、fromArray()
        //a.作用：快速创建一个被观察者对象（Observable）
        // 发送事件特点：发送传入的数组数据（以数组形式发送10个以上事件）

        //b.具体使用
        //  1.设置需要传入的数组
        Integer[] items={1,2,3,4,5};

        Observable.fromArray(items).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


        //二、fromIterable
        //a.作用快速创建一个Observable对象
        // 发送事件特点：直接发送传入的集合List数据（以集合形式发送10个以上事件）

        //2.具体使用
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Observable.fromArray(list).subscribe(new Observer<List<Integer>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Integer> integers) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }


    /**
     * 延迟创建
     */
    public void delayCreate(){

    }
}
