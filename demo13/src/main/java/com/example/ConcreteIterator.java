package com.example;


import java.util.ArrayList;
import java.util.List;

public class ConcreteIterator<T> implements Iterator<T> {

    private List<T> mList = new ArrayList<>();
    private int mCursor = 0;

    public ConcreteIterator(List<T> list) {
        mList = list;
    }

    @Override
    public boolean hasNext() {
        return mCursor != mList.size();
    }

    @Override
    public T next() {
        T obj = null;
        if (this.hasNext()) {
            obj = this.mList.get(mCursor++);
        }
        return obj;
    }
}
