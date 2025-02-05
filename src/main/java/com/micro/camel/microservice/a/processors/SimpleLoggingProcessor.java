package com.micro.camel.microservice.a.processors;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class SimpleLoggingProcessor implements Processor { // This is a processor as it implements Processor
    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("SimpleLoggingProcessor.process() {} ",exchange.getMessage().getBody());//gets the message(string)
    }
}
