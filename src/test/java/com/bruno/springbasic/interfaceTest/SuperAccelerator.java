package com.bruno.springbasic.interfaceTest;

public class SuperAccelerator implements Accelerator {

    @Override
    public void run() {
        System.out.println("슈퍼 빠르게 가자");
    }

    @Override
    public void back() {
        System.out.println("슈퍼 뒤로 빠르게 가자");
    }
}
