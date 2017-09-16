package com.example.test1;


public class ConcreteCommand implements Command {

    // 持有一个对接收者对象的引用
    private Receiver mReceiver;

    public ConcreteCommand(Receiver receiver) {
        mReceiver = receiver;
    }

    @Override
    public void execute() {
        // 调用接收者的相关方法来执行具体逻辑
        mReceiver.action();
    }
}
