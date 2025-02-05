package com.micro.camel.microservice.a.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SimpleLoggingProcessorBean { // This is a bean not a processor as it does not implements processor
//using bean wo do process(not changing the input message just forward it to database or log it)
    public void process(String message){
        log.info("SimpleLoggingProcessorBean.process {} ",message);
    }
}
