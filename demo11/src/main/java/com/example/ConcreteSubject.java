package com.example;


import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject extends Subject {

    private List<Observer> mObserverList = new ArrayList<>();

    @Override
    void notifyObservers(Object object) {
        for (Observer observer : mObserverList) {
            observer.update(object);
        }
    }

    @Override
    void addObserver(Observer observer) {
        mObserverList.add(observer);
    }

    @Override
    void removeObserver(Observer observer) {
        mObserverList.remove(observer);
    }
}
