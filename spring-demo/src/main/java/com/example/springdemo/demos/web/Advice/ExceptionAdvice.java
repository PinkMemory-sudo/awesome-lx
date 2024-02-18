package com.example.springdemo.demos.web.Advice;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public R<String> handleException(MethodArgumentNotValidException ex){
//        String msg = ex.getBindingResult().getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));
//        return R
//                .error(msg);
//    }

}
