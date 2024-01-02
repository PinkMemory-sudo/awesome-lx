package com.example.springdemo.demos.web.orderState;

/**
 * 完成医嘱
 */
public class CompleteState implements OrderExecState {

    private CompleteState() {
    }

    private static final CompleteState instance = new CompleteState();

    public static OrderExecState getInstance() {
        return CompleteState.instance;
    }

    @Override
    public void preconditionCheck() {
        System.out.println("是否执行中");
    }

    @Override
    public void action() {
        System.out.println("已完成");
    }

}
