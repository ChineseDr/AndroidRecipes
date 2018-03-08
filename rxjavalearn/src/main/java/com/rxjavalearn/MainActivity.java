package com.rxjavalearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
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
     * 1.just()
     * 2.fromArray()
     * 3.fromIterable()
     * 4.never()
     * 5.empty()
     * 6.error()
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


        //三、fromIterable
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
     * 1.defer()
     * 2.timer()
     * 3.interval()
     * 4.intervalRange
     * 5.range()
     * 6.rangeLong()
     */
    Integer i=1;
    public void delayCreate(){

        //一、defer()
        //a.作用：直到有观察者被创建时才动态的创建被观察者和发送事件，
        //  1.通过Observable工厂方法创建被观察者对象，
        //  2.每次订阅后都会获得一个刚创建的最新的Observable对象，可以确保Observable对象中的数据是最新的
        //b.使用场景：动态创建被观察者对象 & 获取最新数据

        //c.具体实现
        i=10;//第一次为i赋值
        //1.通过defer()定义被观察者对象Observable，注：此时被观察者还未被创建
        Observable<Integer> observable=Observable.defer(new Callable<ObservableSource<? extends Integer>>() {
            @Override
            public ObservableSource<? extends Integer> call() throws Exception {
                return Observable.just(i);//匿名内部类访问外部类的局部变量必须时final的，
                // 内部类回调外部类方法时，局部变量可能已经改变，内部类是copy了变量到内部类，
                // 为了防止外部类修改变量的值，导致外部类和内部类的值不一致，所以声明为final
            }
        });

        i=15;
        //观察者开始订阅
        //此时调用defer创建被观察者对象
        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG,"通过subscribe（订阅）连接观察者和被观察者");
            }

            @Override
            public void onNext(Integer value) {
                Log.d(TAG,"响应事件");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        //二、timer()
        //a.作用：快速创建一个被观察者，延迟指定时间后发送一个数值0
        //b.使用场景：检测

        //c.使用：
        Observable.timer(2, TimeUnit.SECONDS).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


        //三、interval()
        //a.作用：快速创建一个被观察者对象
        //b.发送事件特点：每隔指定时间发送事件（发送事件序列：从0开始每次+1无限递增）

        //c.具体实现
        //参数说明：第一个：第一次延迟时间，第二个：间隔时间的数字，第三个：间隔时间的单位（分，秒……等）
        //本例：延迟3秒后发送第一个事件，之后每秒产生一个数字（从0开始）
        Observable.interval(3,1,TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });//延迟3秒后发送第一个事件，之后每秒产生一个数字（从0开始）


        //四、intervalRange()
        //a.作用：类似interval(),
        //b.发送事件特点：类似interval，但是可以指定发送事件的数量

        //c.具体实现
        //参数说明：
        Observable.intervalRange()
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        //五、range()
        //a.快速创建
        //b.
        //c.
        //六、rangeLong()
        //a.
        //b.
        //c.
    }
}
