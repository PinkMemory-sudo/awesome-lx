package com.example.springdemo.demos.web.orderState;

public class SuspendState implements OrderExecState {

    private SuspendState() {
    }

    private static final OrderExecState instance = new SuspendState();

    public static OrderExecState getInstance() {
        return SuspendState.instance;
    }

    @Override
    public void preconditionCheck() {
        System.out.println("是否在运行中");
    }

    @Override
    public void action() {
        System.out.println("已暂停");
    }

}
