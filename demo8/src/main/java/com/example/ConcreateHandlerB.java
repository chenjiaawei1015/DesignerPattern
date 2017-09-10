package com.example;


public class ConcreateHandlerB extends Handler {

    @Override
    public <T extends Handler> void handleRequest(Class<T> condition) {
        if (condition.getName().equalsIgnoreCase(ConcreateHandlerB.class.getName())) {
            System.out.println("B work");
        } else {
            if (mNextHandler != null) {
                mNextHandler.handleRequest(condition);
            } else {
                System.out.println("B work");
            }
        }
    }
}
