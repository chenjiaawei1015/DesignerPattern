package com.example.test1;


/**
 * 抽象根节点
 */
public abstract class Component {

    // 节点名
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void doSomeThing();
}
