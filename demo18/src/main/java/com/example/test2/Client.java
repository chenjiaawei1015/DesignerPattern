package com.example.test2;


public class Client {

    public static void main(String[] args) {
        // 构造根节点
        Component root = new Composite("root");

        // 构造两个枝干节点
        Component branch1 = new Composite("branch1");
        Component branch2 = new Composite("branch2");

        // 构造两个叶子节点
        Component leaf1 = new Leaf("leaf1");
        Component leaf2 = new Leaf("leaf2");

        // 叶子节点添加到枝干节点
        branch1.addChild(leaf1);
        branch2.addChild(leaf2);

        // 枝干节点添加到根节点
        root.addChild(branch1);
        root.addChild(branch2);

        root.doSomeThing();
    }
}
