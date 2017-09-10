package com.example;


public abstract class Handler {

    // 设置下一级的处理者
    protected Handler mNextHandler;

    public void setNextHandler(Handler nextHandler) {
        mNextHandler = nextHandler;
    }

    // 处理请求
    public abstract <T extends Handler> void handleRequest(Class<T> condition);
}
