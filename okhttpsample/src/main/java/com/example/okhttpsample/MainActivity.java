package com.example.okhttpsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.okhttpsample.util.RayLog;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doGet(View view){
        //1.需要一个OkhttpClint对象，全局执行者
        OkHttpClient okHttpClient =new OkHttpClient();
        //2.构造Request
        Request.Builder builder =new Request.Builder();
        //请求
        Request request = builder.get().url("https://www.baidu.com/").build();
        //将request封装为Call
        Call call = okHttpClient.newCall(request);
        //


            //Response response = call.execute();
            //异步方法
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                RayLog.e("onFailure"+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                RayLog.e("onResponse:");
                String res=response.body().string();
                RayLog.e(res);
            }

        });


    }
}
