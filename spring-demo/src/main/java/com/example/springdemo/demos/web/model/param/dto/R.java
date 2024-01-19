package com.example.springdemo.demos.web.model.param.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class R<T> {

    private String code;

    private String msg;

    private T data;


    public static <T> R<T> error(String msg) {
        return new R<>("999", msg, null);
    }

    public static <T> R<T> success(T t) {
        return new R<>("000", "success", t);
    }
}
