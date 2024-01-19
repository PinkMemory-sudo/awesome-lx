package com.example.springdemo.demos.web.model.param;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserListQuery {

    @NotEmpty(message = "name不能为空")
    private String name;

    @NotEmpty(message = "gander不能为空")
    private String gander;
}
