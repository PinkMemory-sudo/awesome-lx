package com.example.springdemo.demos.web.orderState;

/**
 * 执行中
 */
public class RunningState implements OrderExecState {

    private RunningState() {
    }

    private static final RunningState instance = new RunningState();

    public static OrderExecState getInstance() {
        return RunningState.instance;
    }

    @Override
    public void preconditionCheck() {
        System.out.println("已完成");
    }

    @Override
    public void action() {
        System.out.println("执行中");
    }

}
