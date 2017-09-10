package com.example;

public class Client {

    public static void main(String[] args) {
        Handler handlerA = new ConcreateHandlerA();
        Handler handlerB = new ConcreateHandlerB();
        Handler handlerC = new Handler() {
            @Override
            public <T extends Handler> void handleRequest(Class<T> condition) {
                System.out.println("C work");
            }
        };

        // 设置下一级
        handlerA.setNextHandler(handlerB);

        handlerA.handleRequest(handlerA.getClass());
        handlerA.handleRequest(handlerB.getClass());
        handlerA.handleRequest(handlerC.getClass());

        // 输出
        // A work
        // B work
        // B work
    }
}
