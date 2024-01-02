package com.example.springdemo.demos.web.controller;

import com.example.springdemo.demos.web.model.param.OrderExecRequest;
import com.example.springdemo.demos.web.orderState.OrderExecState;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/param")
public class ParamApi {

    @PostMapping("/enum")
    public void getEnum(@RequestBody OrderExecRequest orderExecRequest) {

        OrderExecState orderExecState = orderExecRequest.getExecType().getOrderExecState();
        orderExecState.preconditionCheck();
        orderExecState.action();
    }
}
