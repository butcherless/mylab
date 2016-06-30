package com.cmartin.learn.mybank.service;

import com.cmartin.learn.mybank.dto.DomainFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by cmartin on 19/06/16.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
public class ApiDocumentation {


    @Rule
    public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

    private MockMvc mockMvc;

    private PrettyPrintConverter prettyPrintConverter = new PrettyPrintConverter(true);

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new MyBankController()).setMessageConverters(this.prettyPrintConverter)
                .apply(documentationConfiguration(this.restDocumentation))
                .build();

//        this.mockMvc= MockMvcBuilders.webAppContextSetup(this.context)
//                .apply(documentationConfiguration(this.restDocumentation)).build();

//        this.specification = new RequestSpecBuilder().addFilter(
//                documentationConfiguration(this.restDocumentation))
//                .build();
    }


    @Test
    public void testGetAccountList() throws Exception {
        this.mockMvc.perform(get("/accounts/").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())

                .andDo(document("account-list",
                        responseFields(
                                fieldWithPath("[].number").description("número de cuenta"),
                                fieldWithPath("[].alias").description("alias para la cuenta"),
                                fieldWithPath("[].balance").description("saldo de la cuenta"))));

    }

    @Test
    public void testGetAccountListWithPagination() throws Exception {
        this.mockMvc.perform(get("/accounts/?paginationSize=7"))
                .andDo(print())
                .andExpect(status().isOk())

                .andDo(document("account-list-page",
                        responseFields(
                                fieldWithPath("[].number").description("número de cuenta"),
                                fieldWithPath("[].alias").description("alias para la cuenta"),
                                fieldWithPath("[].balance").description("saldo de la cuenta"))));
/*
        given()
                .standaloneSetup(new MyBankController()).
                when()
                .get("/accounts/?paginationSize=7").
                then().
                statusCode(200);
        //body("entity-1.entity-2", equalTo(3));
 */
    }

    @Ignore
    @Test
    public void testGetAccountListWithPaginationLimit() {
/*
        given()
                .standaloneSetup(new MyBankController()).
                when()
                .get("/accounts/?paginationSize=20").
                then().
                statusCode(200);
        //body("entity-1.entity-2", equalTo(3));
        */
    }

    @Test
    public void testGetAccount() throws Exception {
        this.mockMvc.perform(get("/accounts/AB1122223333441234567890").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("account-get",
                        responseFields(
                                fieldWithPath("number").description("número de cuenta"),
                                fieldWithPath("alias").description("alias para la cuenta"),
                                fieldWithPath("balance").description("saldo de la cuenta"))));
    }


    @Test
    public void testGetNotFound() throws Exception {
        this.mockMvc.perform(get("/notFound/").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }


    @Test
    public void testGetAccountTransactionList() throws Exception {
        this.mockMvc.perform(get("/accounts/1234567890/accountTransactions").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("accountTransaction-list",
                        responseFields(
                                fieldWithPath("[].amount").description("cantidad monetaria del movimiento"),
                                fieldWithPath("[].amount.value").description("cuantía del movimiento"),
                                fieldWithPath("[].amount.currency").description("divisa del movimiento"),
                                fieldWithPath("[].transactionDate").description("fecha del movimiento"),
                                fieldWithPath("[].date").description("fecha de consolidación del movimiento"),
                                fieldWithPath("[].description").description("descripción del movimiento"))));
    }


    @Test
    public void testFactory() {
        new DomainFactory();
    }


    // H E L P E R S
    private final class PrettyPrintConverter extends MappingJackson2HttpMessageConverter {
        public PrettyPrintConverter(Boolean prettyPrint) {
            super();
            this.setPrettyPrint(prettyPrint);
        }
    }


}
