package com.example.springdemo.demos.web.model.param.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class R<T> {

    private String code;

    private String msg;

    private T data;


//    public static  R error(String msg) {
//        R<Object> objectR = new R<>();
//        return objectR;
//    }

//    public static <T> R<T> success(T t) {
//        return new R<>("000", "success", t);
//    }
}
