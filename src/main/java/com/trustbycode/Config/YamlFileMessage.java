package com.trustbycode.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YamlFileMessage {
    @Value("${pro.message.config}")
    private String messageConfig;

    @GetMapping("/")
    public String getMessageConfig(){
        return messageConfig;
    }
}
