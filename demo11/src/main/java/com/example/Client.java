package com.example;

public class Client {

    public static void main(String[] args) {
        Observer observer1 = new ConcreteObserver();
        Observer observer2 = new ConcreteObserver();

        Subject subject = new ConcreteSubject();
        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.notifyObservers("Android");

        subject.removeObserver(observer1);
        subject.removeObserver(observer2);
        subject.notifyObservers("Java");
    }
}
