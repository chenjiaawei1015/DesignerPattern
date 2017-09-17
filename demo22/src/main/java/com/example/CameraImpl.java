package com.example;


public class CameraImpl implements Camera {
    @Override
    public void open() {
        System.out.println("open");
    }

    @Override
    public void takePicture() {
        System.out.println("takePicture");
    }

    @Override
    public void close() {
        System.out.println("close");
    }
}
