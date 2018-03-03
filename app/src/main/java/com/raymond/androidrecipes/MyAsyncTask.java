package com.raymond.androidrecipes;

import android.os.AsyncTask;

import java.sql.ParameterMetaData;

/**
 * Created by ray on 2018/3/3.
 */

public class MyAsyncTask extends AsyncTask {
    /**
     * 执行线程任务前的操作
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /**
     * 接收参数，执行耗时操作，返回操作结果
     * @param objects
     * @return
     */
    @Override
    protected String doInBackground(Object[] objects) {
        return null;
    }

    /**
     * 在主线程显示任务执行进度
     * @param values
     */
    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
    }

    /**
     * 接收线程任务执行结果，将执行结果显示到UI组件
     * @param o
     */
    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
}
