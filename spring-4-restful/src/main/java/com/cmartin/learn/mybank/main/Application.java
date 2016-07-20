package com.cmartin.learn.mybank.main;

import com.cmartin.learn.mybank.service.MyBankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by cmartin on 20/07/16.
 */
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        MyBankService myBankService = ctx.getBean(MyBankService.class);

        logger.debug("\ntest logging with slf4j");
        myBankService.getAccounts(0).size();
    }
}
