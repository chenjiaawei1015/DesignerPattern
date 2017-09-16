package com.example;


import java.util.ArrayList;
import java.util.List;

public class ConcreteAggregate<T> implements Aggregate<T> {

    private List<T> mList = new ArrayList<>();

    @Override
    public void add(T obj) {
        mList.add(obj);
    }

    @Override
    public void remove(T obj) {
        mList.remove(obj);
    }

    @Override
    public Iterator<T> iterator() {
        return new ConcreteIterator<>(mList);
    }
}
