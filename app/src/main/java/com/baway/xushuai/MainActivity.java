package com.baway.xushuai;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.baway.xushuai.adapter.MyAdapter;
import com.baway.xushuai.bean.News;
import com.baway.xushuai.utils.NetDataCallback;
import com.baway.xushuai.utils.OkHttpUtils;
import com.baway.xushuai.utils.SpacesItemDecoration;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NetDataCallback<News> {

    private XRecyclerView mrv;
    private MyAdapter md;
    private ArrayList<News.美女Bean> mlist = new ArrayList<>();
    private OkHttpUtils http;
    private String url = "http://c.3g.163.com/recommend/getChanListNews?channel=T1456112189138&size=20&passport=&devId=1uuFYbybIU2oqSRGyFrjCw%3D%3D&lat=%2F%2FOm%2B%2F8ScD%2B9fX1D8bxYWg%3D%3D&lon=LY2l8sFCNzaGzqWEPPgmUw%3D%3D&version=9.0&net=wifi&ts=1464769308&sign=bOVsnQQ6gJamli6%2BfINh6fC%2Fi9ydsM5XXPKOGRto5G948ErR02zJ6%2FKXOnxX046I&encryption=1&canal=meizu_store2014_news&mac=sSduRYcChdp%2BBL1a9Xa%2F9TC0ruPUyXM4Jwce4E9oM30%3D";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (isNetworkAvailable(this)) {
            //有网的情况
            Toast.makeText(MainActivity.this, "网络加载中....", Toast.LENGTH_SHORT).show();
            mrv = (XRecyclerView) findViewById(R.id.recycler);
            //设置间隔
            SpacesItemDecoration decoration = new SpacesItemDecoration(16);
            mrv.addItemDecoration(decoration);

            //加载网络数据
            loaddata();
            md = new MyAdapter(this, mlist);
            mrv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            mrv.setAdapter(md);
            //属性动画渐变
            ObjectAnimator animation = ObjectAnimator.ofFloat(mrv, "rotation", 0, 360);
            animation.setDuration(5000);
            animation.start();
            //item条目的点击事件
            md.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int postion) {
                    Toast.makeText(MainActivity.this, mlist.get(postion-1).getDigest(), Toast.LENGTH_SHORT).show();
                }
            });
            //加载更多的点击事件
            mrv.setLoadingListener(new XRecyclerView.LoadingListener() {
                @Override
                public void onRefresh() {
                    //刷新的方法
                    mlist.clear();
                    loaddata();
                    mrv.refreshComplete();
                }

                @Override
                public void onLoadMore() {
                    //加载更多的方法
                    loaddata();
                    mrv.loadMoreComplete();

                }
            });
        } else {
            //没网的情况，提示去手动开启网络
            Toast.makeText(MainActivity.this, "网络不可用", Toast.LENGTH_SHORT).show();
            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    .setTitle("提示")
                    .setMessage("当前网络不可用，是否去设置网络")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent("android.settings.WIFI_SETTINGS");
                            startActivity(intent);

                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();
                        }
                    });
            builder.create().show();
        }
    }

    private void loaddata() {
        http = new OkHttpUtils();
        http.getdata(url, this, News.class);
    }

    //请求成功的方法
    @Override
    public void success(News news) {
        Log.e("News的数据", news.toString());
        mlist = (ArrayList<News.美女Bean>) news.get美女();
        md.setdata(mlist);
        md.notifyDataSetChanged();

    }

    @Override
    public void fail(int code, String str) {

    }

    //判断有无网络的方法
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                // 当前网络是连接的
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    // 当前所连接的网络可用
                    return true;
                }
            }
        }
        return false;
    }
}