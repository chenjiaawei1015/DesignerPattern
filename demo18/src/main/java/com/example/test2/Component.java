package com.example.test2;


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

    public abstract void addChild(Component child);

    public abstract void removeChild(Component child);

    public abstract Component getChild(int index);
}
