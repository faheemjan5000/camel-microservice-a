package com.micro.camel.microservice.a.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyFirstTimerRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        //queue...Timer
        //transformation
        //database....log
        from("timer:first-timer")
                .transform().constant("Local time is : "+ LocalDateTime.now())
                .to("log:first-timer");

    }
}
