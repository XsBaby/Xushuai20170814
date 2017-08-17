package com.baway.xushuai.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baway.xushuai.R;
import com.baway.xushuai.bean.News;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * date:2017/8/14
 * author:徐帅(acer)
 * funcation:RecycleView的适配器
 */

public class MyAdapter extends RecyclerView.Adapter {
    private View view;
    private Context mcontext;
    private ArrayList<News.美女Bean> mlist = new ArrayList<>();
    private OnItemClickListener mClickListener;

    public MyAdapter(Context mcontext, ArrayList<News.美女Bean> list) {
        this.mcontext = mcontext;
        this.mlist = list;
    }

    //找到需要导入的布局
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(mcontext).inflate(R.layout.item, null);
        return new ViewHolder(view, mClickListener);
    }

    //加载相应的内容
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewholder = (ViewHolder) holder;
        Glide.with(mcontext).load(getItem(position).getImgsrc()).into(viewholder.ima);
    }

    //手写的重置数据的方法
    public void setdata(ArrayList<News.美女Bean> list) {
        if (list != null && list.size() > 0) {
            mlist.addAll(list);
        }
    }

    //手写的获得视图的方法
    public News.美女Bean getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    //定义的ViewHolder类继承RecyclerView.ViewHolder 并找到布局中的ID
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private OnItemClickListener mListener;// 声明自定义的接口
        private ImageView ima;

        public ViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            mListener = listener;
            //给item设置点击事件
            itemView.setOnClickListener(this);
            ima = (ImageView) itemView.findViewById(R.id.imageview);
        }

        @Override
        public void onClick(View v) {
            // getpostion()为Viewholder自带的一个方法，用来获取RecyclerView当前的位置，将此作为参数，传出去
            mListener.onItemClick(v, getPosition());
        }
    }

    //手写的一个接口
    public interface OnItemClickListener {
        public void onItemClick(View view, int postion);
    }

    //自定义的方法
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mClickListener = listener;
    }
}