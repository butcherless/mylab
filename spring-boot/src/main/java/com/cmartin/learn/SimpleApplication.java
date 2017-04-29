package com.cmartin.learn;

import com.cmartin.learn.service.DummyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by cmartin on 28/04/2017.
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class SimpleApplication implements CommandLineRunner {

    private final static Logger logger = LoggerFactory.getLogger(SimpleApplication.class);

    private final DummyService service;

    public SimpleApplication(DummyService service) {
        this.service = service;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SimpleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.debug("This message, {}, comes from a Spring Boot Application", service.upperMessage("hello world!"));
    }
}