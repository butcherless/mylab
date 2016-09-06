package com.cmartin.learn.mybank.controller;

import com.cmartin.learn.mybank.dto.DomainFactory;
import com.cmartin.learn.mybank.service.MyBankService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by cmartin on 07/07/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:test-application-context.xml")
public class ControllerTest {

    @Autowired
    private MyBankService mockService;

    @Autowired
    private WebApplicationContext applicationContext;

    private MockMvc mockMvc;

    private static MediaType JSON_MEDIA_TYPE = MediaType.parseMediaType("application/json;charset=UTF-8");

    protected static final ResultMatcher contentTypeJson = content()
            .contentType(JSON_MEDIA_TYPE);


    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.applicationContext)
                .build();
    }

    @Test
    public void test() throws Exception {

        when(this.mockService.getAccounts(5))
                .thenReturn(DomainFactory.newAccountDTOList(5));


        this.mockMvc.perform(get("/under-development")
                .accept(JSON_MEDIA_TYPE))
                .andDo(print())
                .andExpect(status().isOk());

//TODO        verify(this.mockService).getAccounts(5);
    }
}
