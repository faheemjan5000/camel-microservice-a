package com.micro.camel.microservice.a.route;

import com.micro.camel.microservice.a.beans.GetCurrentTimeBean;
import com.micro.camel.microservice.a.beans.SimpleLoggingProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyFirstTimerRouter extends RouteBuilder {
    @Autowired
    private GetCurrentTimeBean getCurrentTimeBean;
    @Autowired
    private SimpleLoggingProcessor simpleLoggingProcessor;

    @Override
    public void configure() throws Exception {
        //queue...Timer
        //transformation
        //database....log
        from("timer:first-timer")
                //.transform().constant("Local time is : "+ LocalDateTime.now()) this time is constant
                .bean(getCurrentTimeBean,"getCurrentTime") //here the time changes at each second i.e real time
                .bean(simpleLoggingProcessor)
                .to("log:first-timer");

    }
}

