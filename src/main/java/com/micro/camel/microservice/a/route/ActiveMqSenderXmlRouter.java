package com.micro.camel.microservice.a.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqSenderXmlRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("file:files/xml")
                .log("${body}")
                .to("activemq:my-activemq-xml-queue");
    }
}
