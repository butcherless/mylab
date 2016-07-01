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

import java.util.regex.Matcher;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
    }

    @Test
    public void testGetAccountList() throws Exception {
        this.mockMvc.perform(get("/accounts/").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath(".number").exists())
                .andExpect(jsonPath(".balance").exists())
                // documentation
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
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                // documentation
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
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                // documentation
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
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                // documentation
                .andDo(document("accountTransaction-list",
                        responseFields(
                                fieldWithPath("list.[].id").description("identificador único del movimiento"),
                                fieldWithPath("list.[].amount").description("cantidad monetaria del movimiento"),
                                fieldWithPath("list.[].amount.value").description("cuantía del movimiento"),
                                fieldWithPath("list.[].amount.currency").description("divisa del movimiento"),
                                fieldWithPath("list.[].transactionDate").description("fecha del movimiento"),
                                fieldWithPath("list.[].date").description("fecha de consolidación del movimiento"),
                                fieldWithPath("list.[].description").description("descripción del movimiento"),
                                fieldWithPath("paginationKey").description("clave de paginación para recuperar la siguiente página de resultados"),
                                fieldWithPath("hasNextPage").description("indicador de datos adicionales disponibles"))));
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
