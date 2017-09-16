package com.example;


public class ProxySubject extends Subject {

    private RealSubject mRealSubject;

    public ProxySubject(RealSubject realSubject) {
        mRealSubject = realSubject;
    }

    @Override
    public void visit() {
        mRealSubject.visit();
    }
}
