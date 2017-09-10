package com.example;


public class ConcreateHandlerA extends Handler {

    @Override
    public <T extends Handler> void handleRequest(Class<T> condition) {
        if (condition.getName().equalsIgnoreCase(ConcreateHandlerA.class.getName())) {
            System.out.println("A work");
        } else {
            if (mNextHandler != null) {
                mNextHandler.handleRequest(condition);
            } else {
                System.out.println("A work");
            }
        }
    }
}
