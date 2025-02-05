package com.micro.camel.microservice.a.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqSenderRouter extends RouteBuilder {//this router will send messages to activeMq
    @Override
    public void configure() throws Exception {
        from("timer:active-mq-timer?period=10000")
                //.log("Message generated : ${body}")
                .transform().constant("My message for active mq")
                .log("${body}")
                .to("activemq:my-activemq-queue");//writing it to the queue
    }
}
