package com.example.test1;

/**
 * 具体的叶子节点
 */
public class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void doSomeThing() {
        System.out.println(name);
    }
}
