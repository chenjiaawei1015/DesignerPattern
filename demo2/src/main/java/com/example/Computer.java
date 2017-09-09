package com.example;

public abstract class Computer {

    // 主机
    protected String mBoard;
    // 显示器
    protected String mDisplay;
    // 操作系统
    protected String mOs;

    protected Computer() {
    }

    public void setBoard(String board) {
        mBoard = board;
    }

    public void setDisplay(String display) {
        mDisplay = display;
    }

    public abstract void setOs();
}
