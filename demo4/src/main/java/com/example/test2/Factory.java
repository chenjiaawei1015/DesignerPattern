package com.example.test2;


public abstract class Factory {

    // 创建产品
    public abstract <T extends Product> T createProduct(Class<T> clazz);
}
