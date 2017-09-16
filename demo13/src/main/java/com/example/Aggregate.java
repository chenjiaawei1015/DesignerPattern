package com.example;


public interface Aggregate<T> {

    void add(T obj);

    void remove(T obj);

    Iterator<T> iterator();
}
