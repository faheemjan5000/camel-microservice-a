package com.micro.camel.microservice.a.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SimpleLoggingProcessor {

    public void process(String message){
        log.info(message);
    }
}
