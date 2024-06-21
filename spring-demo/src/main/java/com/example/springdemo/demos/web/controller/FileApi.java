package com.example.springdemo.demos.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/file")
public class FileApi {


    @GetMapping("/test")
    public String test(){
        String filePath = "visitData.txt";
        String fileContent="空";
        try {
            byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));
             fileContent = new String(fileBytes, StandardCharsets.UTF_8);
            System.out.println(fileContent);
        } catch (
                IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return fileContent;
    }

}
