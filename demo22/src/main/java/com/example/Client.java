package com.example;

public class Client {

    public static void main(String[] args) {
        MobilePhone phone = new MobilePhone();
        phone.call();
        phone.takePicture();
        phone.closeCamera();
        phone.handup();
    }
}
