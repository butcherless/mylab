package com.cmartin.learn.mybank.controller;

import com.cmartin.learn.mybank.main.Application;
import com.cmartin.learn.mybank.service.MyBankService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by cmartin on 07/07/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ControllerIntegrationTest {

    @Autowired
    private MyBankService bankService;

    @Autowired
    private MyBankController myBankController;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private static MediaType JSON_MEDIA_TYPE = MediaType.parseMediaType("application/json;charset=UTF-8");

    protected static final ResultMatcher contentTypeJson = content()
            .contentType(JSON_MEDIA_TYPE);



    @Before
    public void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void test() throws Exception {


        this.mockMvc.perform(get("/under-development"))
                .andDo(print())
                .andExpect(status().isOk());

    }
}
