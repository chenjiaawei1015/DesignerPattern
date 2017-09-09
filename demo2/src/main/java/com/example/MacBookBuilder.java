package com.example;


public class MacBookBuilder extends Builder {

    private Computer mComputer = new MacBook();

    @Override
    public void buildBoard(String board) {
        mComputer.setBoard(board);
    }

    @Override
    public void buildDisplay(String display) {
        mComputer.setDisplay(display);
    }

    @Override
    public void buildOs() {
        mComputer.setOs();
    }

    @Override
    public Computer create() {
        return mComputer;
    }
}
