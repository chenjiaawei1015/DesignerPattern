package com.example;

// Adapter 角色,将220v转换为5v
public class VoltAdapter extends Volt220 implements FiveVolt {

    @Override
    public int getVolt5() {
        return 5;
    }
}
