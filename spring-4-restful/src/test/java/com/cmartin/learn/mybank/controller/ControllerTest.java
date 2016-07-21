package com.cmartin.learn.mybank.controller;

import com.cmartin.learn.mybank.dto.DomainFactory;
import com.cmartin.learn.mybank.service.MyBankService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.Charset;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by cmartin on 07/07/16.
 */

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

    @Mock
    private MyBankService bankService;

    @InjectMocks
    private MyBankController myBankController;

    private MockMvc mockMvc;

    private final MediaType contentTypeJson = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    private  final ResultMatcher contentTypeJsonResultMatcher = content().contentType(contentTypeJson);






    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(myBankController).build();
    }

    @Test
    public void test() throws Exception {

        when(this.bankService.getAccounts(5))
                .thenReturn(DomainFactory.newAccountDTOList(5));


        this.mockMvc.perform(get("/under-development")
                .accept(contentTypeJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(contentTypeJsonResultMatcher);

        verify(this.bankService).getAccounts(5);
    }
}
