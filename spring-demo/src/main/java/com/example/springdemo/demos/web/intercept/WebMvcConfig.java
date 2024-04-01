//package com.example.springdemo.demos.web.intercept;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
////@Configuration
//@RequiredArgsConstructor
//public class WebMvcConfig implements WebMvcConfigurer {
//
//    private final PrimaryIntercept primaryIntercept;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(primaryIntercept).excludePathPatterns("/login");
//    }
//}
