package com.example.springdemo.demos.web.orderState;

public class StopState implements OrderExecState {

    private StopState() {
    }

    private static final OrderExecState instance = new StopState();

    public static OrderExecState getInstance() {
        return StopState.instance;
    }

    @Override
    public void preconditionCheck() {
        System.out.println("是否在运行中");
    }

    @Override
    public void action() {
        System.out.println("已终止");
    }

}
