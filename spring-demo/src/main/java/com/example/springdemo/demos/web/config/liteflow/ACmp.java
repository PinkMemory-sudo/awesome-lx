package com.example.springdemo.demos.web.config.liteflow;

import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

@Component("a")
public class ACmp extends NodeComponent {

    @Override
    public void process() {
        System.out.println("a");
    }
}

