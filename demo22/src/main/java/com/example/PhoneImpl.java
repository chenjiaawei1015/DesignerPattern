package com.example;


public class PhoneImpl implements Phone {

    @Override
    public void call() {
        System.out.println("call");
    }

    @Override
    public void hangup() {
        System.out.println("hangup");
    }
}
