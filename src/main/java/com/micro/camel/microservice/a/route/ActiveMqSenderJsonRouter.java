package com.micro.camel.microservice.a.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component   ############## REMOVE THE COMMENT WHEN TO USE IT ####################
public class ActiveMqSenderJsonRouter extends RouteBuilder {//this router will send messages to activeMq
    @Override
    public void configure() throws Exception {

        //timer endpoint i.e reading from timer
//        from("timer:active-mq-timer?period=10000")
//                //.log("Message generated : ${body}")
//                .transform().constant("My message for active mq")
//                .log("${body}")
//                .to("activemq:my-activemq-queue");//writing it to the queue

        //file endpoint i.e reading from a file and save it to activemq
        from("file:files/json")
                .log("${body}")
                .to("activemq:my-activemq-queue");//writing it to the queue
    }
}
