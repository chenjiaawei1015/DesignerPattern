package com.example.test2;

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

    @Override
    public void addChild(Component child) {
        throw new RuntimeException("叶子节点没有子节点");
    }

    @Override
    public void removeChild(Component child) {
        throw new RuntimeException("叶子节点没有子节点");
    }

    @Override
    public Component getChild(int index) {
        throw new RuntimeException("叶子节点没有子节点");
    }
}
