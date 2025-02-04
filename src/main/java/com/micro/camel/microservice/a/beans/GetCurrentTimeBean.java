package com.micro.camel.microservice.a.beans;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class GetCurrentTimeBean{
    public String getCurrentTime(){
        return "Current time is : " + LocalDateTime.now();
    }
}
