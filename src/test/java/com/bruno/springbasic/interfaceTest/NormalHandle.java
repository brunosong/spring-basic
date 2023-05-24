package com.bruno.springbasic.interfaceTest;

public class NormalHandle implements Handle {

    @Override
    public void left() {
        System.out.println("왼쪽으로");
    }

    @Override
    public void right() {
        System.out.println("오른쪽으로");
    }
}
