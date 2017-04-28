package com.cmartin.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by cmartin on 28/04/2017.
 */
@EnableAutoConfiguration
public class SimpleApplication {

    private static final Logger logger = Logger.getLogger(SimpleApplication.class.getName());

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SimpleApplication.class, args);

        logger.log(Level.INFO, "Spring Boot Application log message");
    }
}