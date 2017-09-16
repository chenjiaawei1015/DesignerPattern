package com.example;


public abstract class Subject {

    abstract void notifyObservers(Object object);

    abstract void addObserver(Observer observer);

    abstract void removeObserver(Observer observer);
}
