package com.example;


public class TvController implements PowerController {

    // 默认关机状态
    private TvState mTvState = new PowerOffState();

    @Override
    public void powerOn() {
        mTvState = new PowerOnState();
        System.out.println("power on");
    }

    @Override
    public void powerOff() {
        mTvState = new PowerOffState();
        System.out.println("power off");
    }

    // 下一个频道
    public void changeChannel() {
        mTvState.changeChannel();
    }
}
