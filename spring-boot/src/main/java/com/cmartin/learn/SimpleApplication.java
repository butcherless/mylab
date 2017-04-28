package com.cmartin.learn;

import com.cmartin.learn.config.ApplicationConfiguration;
import com.cmartin.learn.service.DummyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by cmartin on 28/04/2017.
 */
@EnableAutoConfiguration
public class SimpleApplication {

    private static final Logger logger = Logger.getLogger(SimpleApplication.class.getName());

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfiguration.class, args);

        DummyService dummyService = context.getBean(DummyService.class);

        logger.log(Level.INFO, "Spring Boot Application log message: " + dummyService.upperMessage("hello world!"));
    }
}