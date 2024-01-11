package com.example.springdemo.demos.web.orderState;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExecType {

    /**
     * 开始操作
     */
    START_OPERATION("开始", RunningState.getInstance()),

    /**
     *
     */
    PERFORM_OPERATION("执行", RunningState.getInstance()),

    /**
     * 完成
     */
    COMPLETE_OPERATION("完成", CompleteState.getInstance()),

    /**
     * 取消完成
     */
    CANCEL_OPERATION("取消完成", RunningState.getInstance()),

    /**
     * 取消暂停
     */
    RESUME_OPERATION("取消暂停", RunningState.getInstance()),

    /**
     * 执行操作
     */
    SUSPEND_OPERATION("暂停", SuspendState.getInstance());

    @JsonValue
    private final String code;

    /**
     * 动作绑定的状态
     */
    private final OrderExecState orderExecState;
}
