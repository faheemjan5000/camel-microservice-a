package com.micro.camel.microservice.a.route;

import com.micro.camel.microservice.a.beans.GetCurrentTimeBean;
import com.micro.camel.microservice.a.beans.SimpleLoggingProcessorBean;
import com.micro.camel.microservice.a.processors.SimpleLoggingProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Component;

//@Component when its commented no route is created so we disable it
public class MyFirstTimerRouter extends RouteBuilder {
    @Autowired
    private GetCurrentTimeBean getCurrentTimeBean;
    @Autowired
    private SimpleLoggingProcessorBean simpleLoggingProcessorBean;

    @Autowired
    private SimpleLoggingProcessor simpleLoggingProcessor;

    @Override
    public void configure() throws Exception {
        //queue...Timer       //input to read
        //transformation      //data to process or transform
        //database....log     //write to database(output)
        from("timer:first-timer")
                //.transform().constant("Local time is : "+ LocalDateTime.now()) this time is constant
                .bean(getCurrentTimeBean,"getCurrentTime") //here the time changes at each second i.e real time
                .bean(simpleLoggingProcessorBean)
                .process(simpleLoggingProcessor)
                .to("log:first-timer");

    }
}

