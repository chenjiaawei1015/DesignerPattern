package com.example;

public class Client {

    public static void main(String[] args) {
        Subject subject = new RealSubject();
        Subject proxySubject = new ProxySubject((RealSubject) subject);
        proxySubject.visit();
    }
}
