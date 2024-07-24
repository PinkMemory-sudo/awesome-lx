package com.example.springdemo.demos.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EicuDictInfo {

    private String hospArea;
    private String parentId;
    private String dictName;
    private String primaryId;
    private String dictValue;
    private int dictStatus;
}