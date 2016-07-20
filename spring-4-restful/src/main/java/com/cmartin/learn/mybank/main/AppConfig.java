package com.cmartin.learn.mybank.main;

import com.cmartin.learn.mybank.service.MyBankService;
import com.cmartin.learn.mybank.service.MyBankServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by cmartin on 20/07/16.
 */
@Configuration
public class AppConfig {

    @Bean
    public MyBankService myBankService() {
        return new MyBankServiceImpl();
    }
}
