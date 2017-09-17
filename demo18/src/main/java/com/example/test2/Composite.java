package com.example.test2;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的枝干接点
 */
public class Composite extends Component {

    private List<Component> mComponentList = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void doSomeThing() {
        System.out.println(name);
        for (Component component : mComponentList) {
            component.doSomeThing();
        }
    }

    @Override
    public void addChild(Component child) {
        mComponentList.add(child);
    }

    @Override
    public void removeChild(Component child) {
        mComponentList.remove(child);
    }

    @Override
    public Component getChild(int index) {
        return mComponentList.get(index);
    }
}
