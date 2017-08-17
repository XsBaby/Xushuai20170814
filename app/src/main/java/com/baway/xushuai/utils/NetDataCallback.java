package com.baway.xushuai.utils;

/**
 * 接口
 */
public interface NetDataCallback<T> {
    void success(T t);

    void fail(int code, String str);
}