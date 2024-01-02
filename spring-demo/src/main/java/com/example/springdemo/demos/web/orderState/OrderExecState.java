package com.example.springdemo.demos.web.orderState;

public interface OrderExecState {

    /**
     * 状态转移前置条件判断
     */
    void preconditionCheck();

    /**
     * 状态转移动作
     */
    void action();
}
