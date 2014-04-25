package com.mylab.learn.myarchetype.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/home")
    public String helloWorld() {
        this.logger.debug("request mapping {}", "/home");

        return "home";
    }
}