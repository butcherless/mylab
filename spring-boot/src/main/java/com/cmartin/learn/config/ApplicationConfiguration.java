package com.cmartin.learn.config;

import com.cmartin.learn.repository.DummyRepository;
import com.cmartin.learn.service.DummyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by cmartin on 28/04/2017.
 */
@Configuration
public class ApplicationConfiguration {
    @Bean
    public DummyService newDummyService() {
        return new DummyService();
    }

    @Bean
    public DummyRepository newDummyRepository() {
        return new DummyRepository();
    }
}
