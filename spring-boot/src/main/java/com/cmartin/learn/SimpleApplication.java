package com.cmartin.learn;

import com.cmartin.learn.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by cmartin on 28/04/2017.
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class SimpleApplication implements CommandLineRunner {

    private static final Logger logger = Logger.getLogger(SimpleApplication.class.getName());

    @Autowired
    private DummyService service;

    public static void main(String[] args) throws Exception {
        SpringApplication application = new SpringApplication(SimpleApplication.class);
        application.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.log(Level.INFO, "Spring Boot Application log message: " + service.upperMessage("hello world!"));
    }
}