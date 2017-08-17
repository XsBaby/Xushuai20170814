package com.baway.xushuai.utils;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.R.string.ok;
import static android.icu.text.DateTimePatternGenerator.PatternInfo.OK;

/**
 * 网络请求的工具类
 */
public class OkHttpUtils {
    private Handler hand = new Handler();
    private NetDataCallback netDataCallback;

    public <T> void getdata(String url, final NetDataCallback netDataCallback, final Class<T> tclass) {
        //初始化一个 OkHttpClient 并且设置连接和读取超时时间
        OkHttpClient okhttp = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
        //构造一个Request对象
        Request request = new Request.Builder().url(url).build();
        //通过request的对象去构造得到一个Call对象
        Call call = okhttp.newCall(request);
        //调用的是call.enqueue，将call加入调度队列，然后等待任务执行完成，我们在Callback中即可得到结果。
        call.enqueue(new Callback() {
            //失败的情况
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("///////", "onFailure");
                netDataCallback.fail(499, e.getMessage());
            }

            //成功的情况
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson = new Gson();
                T t = gson.fromJson(response.body().string(), tclass);
                final Message msg = Message.obtain();
                msg.what = ok;
                msg.obj = t;
                hand.post(new Runnable() {
                    @Override
                    public void run() {
                        netDataCallback.success(msg.obj);
                    }
                });
            }
        });
    }

    //post请求
    public <T> void getLoadDataPost(String url, final NetDataCallback netDataCallback, final Class<T> tClass, RequestBody body) {
        this.netDataCallback = netDataCallback;
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(20, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
        final Request request = new Request.Builder().url(url).post(body).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                netDataCallback.fail(499, e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                T t = new Gson().fromJson(response.body().string(), tClass);
                final Message msg = Message.obtain();
                msg.what = OK;
                msg.obj = t;
                hand.post(new Runnable() {
                    @Override
                    public void run() {
                        netDataCallback.success(msg.obj);

                    }
                });
            }
        });
    }
}