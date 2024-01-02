package com.example.springdemo.demos.web.model.param;

import com.example.springdemo.demos.web.orderState.ExecType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderExecRequest {

    private ExecType execType;
}
