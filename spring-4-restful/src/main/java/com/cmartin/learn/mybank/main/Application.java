package com.cmartin.learn.mybank.main;

import com.cmartin.learn.mybank.controller.MyBankController;
import com.cmartin.learn.mybank.service.MyBankServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by cmartin on 20/07/16.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackageClasses ={ MyBankController.class, MyBankServiceImpl.class})
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }
}
