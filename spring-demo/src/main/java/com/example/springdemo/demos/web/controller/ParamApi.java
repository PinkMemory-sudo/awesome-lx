package com.example.springdemo.demos.web.controller;

import com.example.springdemo.demos.web.model.param.OrderExecRequest;
import com.example.springdemo.demos.web.orderState.OrderExecState;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/param")
@Api("参数相关")
public class ParamApi {

    @PostMapping("/enum")
    @ApiOperation("Enum类型的参数")
    public void getEnum(@RequestBody OrderExecRequest orderExecRequest) {

        OrderExecState orderExecState = orderExecRequest.getExecType().getOrderExecState();
        orderExecState.preconditionCheck();
        orderExecState.action();
    }

    @PostMapping("getRequestBody")
    public String getRequestBody(@RequestBody String name) {
        return name;
    }

}
