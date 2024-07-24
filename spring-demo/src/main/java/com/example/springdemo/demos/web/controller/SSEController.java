package com.example.springdemo.demos.web.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.concurrent.Executors;

@RestController
public class SSEController {

    @GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter handleEvents(@RequestParam String name) {
        SseEmitter emitter = new SseEmitter();

        Executors.newSingleThreadExecutor().submit(() -> {
            int i = 0;
            try {
                while (true) {
                    i++;
                    emitter.send(name + i + "\n\n");
                    Thread.sleep(1000);
                    System.out.println(name + i + "\n\n");
                }
//                emitter.complete();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                emitter.completeWithError(e);
            }
        });
        return emitter;
    }
}
