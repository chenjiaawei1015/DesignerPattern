package com.example;


public class MobilePhone {

    private Phone mPhone = new PhoneImpl();
    private Camera mCamera = new CameraImpl();

    public void call() {
        mPhone.call();
    }

    public void handup() {
        mPhone.hangup();
    }

    public void takePicture() {
        mCamera.open();
        mCamera.takePicture();
    }

    public void closeCamera() {
        mCamera.close();
    }
}
