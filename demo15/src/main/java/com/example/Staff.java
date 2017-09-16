package com.example;

/**
 * 员工基类
 */
public abstract class Staff {

    public String name;
    public int kpi;

    public Staff(String name) {
        this.name = name;
        this.kpi = RandomUtils.getInt(10);
    }

    // 接受Visitor的访问
    public abstract void accept(Visitor visitor);
}
