package com.bruno.springbasic.interfaceTest;

public class k3 implements Car {

    Accelerator accelerator = new SuperAccelerator();
    Handle handle = new NormalHandle();

    @Override
    public void 앞으로() {
        accelerator.run();
    }

    @Override
    public void 뒤로() {
        accelerator.back();
    }

    @Override
    public void 좌측으로() {
        handle.left();
    }

    @Override
    public void 우측으로() {
        handle.right();
    }
}
